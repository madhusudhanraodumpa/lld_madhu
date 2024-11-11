package com.design.splitwise.strategies;

import com.design.splitwise.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
   List<Transaction> settleUp(List<Expense> expenses);
}
