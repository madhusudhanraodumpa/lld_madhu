package com.design.splitwise.service;

import com.design.splitwise.exception.UserException;
import com.design.splitwise.model.Expense;
import com.design.splitwise.model.ExpenseUser;
import com.design.splitwise.model.Group;
import com.design.splitwise.model.User;
import com.design.splitwise.repository.ExpenseRepository;
import com.design.splitwise.repository.ExpenseUserRepository;
import com.design.splitwise.repository.GroupRepository;
import com.design.splitwise.repository.UserRepository;
import com.design.splitwise.strategies.SettleUpStrategy;
import com.design.splitwise.strategies.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    private ExpenseUserRepository expenseUserRepository;
    private UserRepository userRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, ExpenseUserRepository expenseUserRepository
    , UserRepository userRepository, @Qualifier("twoSetsSettleUpStrategy") SettleUpStrategy settleUpStrategy,
                          GroupRepository groupRepository) {
        this.expenseRepository=expenseRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.userRepository=userRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository= groupRepository;
    }

    public List<Transaction> settleUpUser(long userId) throws UserException{

        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()) {
            throw new UserException("User does not exits to settleup.");
        }
        User user = optionalUser.get();
        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        List<Expense> allExpenseUserInvolved = new ArrayList<>();

        for (ExpenseUser expenseUser :expenseUsers) {
            allExpenseUserInvolved.add(expenseUser.getExpense());
        }
        List<Transaction> transactions = settleUpStrategy.settleUp(allExpenseUserInvolved);

        List<Transaction> userInvolvedTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getFrom().equals(user) || transaction.getTo().equals(user)) {
                userInvolvedTransactions.add(transaction);
            }
        }
        return userInvolvedTransactions;



    }
    public List<Transaction> settleUpGroup(long groupId) {

        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(!groupOptional.isPresent()) {
            return null;

        }
        Group group = groupOptional.get();

        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);

        return transactions;




    }

}
