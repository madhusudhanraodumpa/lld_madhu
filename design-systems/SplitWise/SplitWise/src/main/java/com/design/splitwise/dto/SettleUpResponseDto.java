package com.design.splitwise.dto;

import com.design.splitwise.strategies.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpResponseDto {
    private List<Transaction> transactions;
    private String status;
    private String message;
    private long userId;

}
