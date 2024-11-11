package com.design.splitwise.repository;

import com.design.splitwise.model.Expense;
import com.design.splitwise.model.ExpenseUser;
import com.design.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long> {

    List<ExpenseUser> findAllByUser(User user);
    List<ExpenseUser> findAllByExpenseIn(List<Expense> expenses);
}
