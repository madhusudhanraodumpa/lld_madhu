package com.design.splitwise.strategies;

import com.design.splitwise.model.Expense;
import com.design.splitwise.model.ExpenseUser;
import com.design.splitwise.model.ExpenseUserType;
import com.design.splitwise.model.User;
import com.design.splitwise.repository.ExpenseUserRepository;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("twoSetsSettleUpStrategy")
public class TwoSetsSettleUpStrategy implements SettleUpStrategy{

    private ExpenseUserRepository expenseUserRepository;
    @Autowired
    public TwoSetsSettleUpStrategy(ExpenseUserRepository expenseUserRepository) {
        this.expenseUserRepository = expenseUserRepository;
    }
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByExpenseIn(expenses);

        Map<User,Integer> extraPaidMoney = new HashMap<>();

        for (ExpenseUser expenseUser :expenseUsers) {
            User user= expenseUser.getUser();
            int extraAmountPaid=0;
            if(expenseUser.getExpenseUserType().equals(ExpenseUserType.PAID)) {
                extraAmountPaid = extraPaidMoney.get(user)+expenseUser.getAmount();
            }else {
                extraAmountPaid = extraPaidMoney.get(user) - expenseUser.getAmount();
            }
            extraPaidMoney.put(user,extraAmountPaid);
        }

        TreeSet<Pair<User,Integer>> extraPaid = new TreeSet<>();
        TreeSet<Pair<User,Integer>> lessPaid = new TreeSet<>();

        for (Map.Entry<User,Integer> extraPaidEntry:extraPaidMoney.entrySet()) {
            if(extraPaidEntry.getValue()>0) {
                extraPaid.add(new Pair<>(extraPaidEntry.getKey(),extraPaidEntry.getValue()));
            } else {
                lessPaid.add(new Pair<>(extraPaidEntry.getKey(),extraPaidEntry.getValue()));
            }
        }

        List<Transaction> transactions = new ArrayList<>();
        while (!lessPaid.isEmpty()) {
            Pair<User,Integer> extraPaidUserPair = extraPaid.pollFirst();
            Pair<User,Integer> lessPaidUserPair = lessPaid.pollFirst();
            Transaction transaction = new Transaction();
            transaction.setFrom(lessPaidUserPair.a);
            transaction.setTo(extraPaidUserPair.a);
            if(Math.abs(lessPaidUserPair.b)< extraPaidUserPair.b) {

                transaction.setAmount(extraPaidUserPair.b-Math.abs(lessPaidUserPair.b));

                if(extraPaidUserPair.b-Math.abs(lessPaidUserPair.b)!=0) {
                    Pair<User,Integer> newExtraPairUser = new Pair<>(extraPaidUserPair.a,extraPaidUserPair.b-Math.abs(lessPaidUserPair.b));
                    extraPaid.add(newExtraPairUser);
                }

            } else {
            transaction.setAmount(extraPaidUserPair.b);
                if(extraPaidUserPair.b-Math.abs(lessPaidUserPair.b)!=0) {
                    Pair<User,Integer> newExtraPairUser = new Pair<>(lessPaidUserPair.a,extraPaidUserPair.b+lessPaidUserPair.b);
                    lessPaid.add(newExtraPairUser);
                }
            }

            transactions.add(transaction);
        }


        return transactions;
    }
}
