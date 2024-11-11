package com.design.splitwise.repository;

import com.design.splitwise.model.Expense;
import com.design.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    List<Expense> findAllByGroup(Group group);
}
