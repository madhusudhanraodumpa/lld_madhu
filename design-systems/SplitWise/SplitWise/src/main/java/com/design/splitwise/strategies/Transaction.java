package com.design.splitwise.strategies;

import com.design.splitwise.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private int amount;

}
