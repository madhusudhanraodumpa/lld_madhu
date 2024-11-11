package com.design.splitwise.controller;

import com.design.splitwise.dto.SettleUpGroupRequestDto;
import com.design.splitwise.dto.SettleUpGroupRersponseDto;
import com.design.splitwise.dto.SettleUpRequestDto;
import com.design.splitwise.dto.SettleUpResponseDto;
import com.design.splitwise.exception.UserException;
import com.design.splitwise.service.ExpenseService;
import com.design.splitwise.strategies.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ExpenseController {
     private ExpenseService expenseService;

     @Autowired
    public ExpenseController(ExpenseService expenseService) {
         this.expenseService = expenseService;
     }

   public SettleUpResponseDto settleUpUser(SettleUpRequestDto settleUpRequestDto) {
         SettleUpResponseDto settleUpResponseDto = new SettleUpResponseDto();
        List<Transaction> userTransactions;
         try {
           userTransactions = expenseService.settleUpUser(settleUpRequestDto.getUserId());
           settleUpResponseDto.setTransactions(userTransactions);
           settleUpResponseDto.setMessage("SUCCESS");
           settleUpResponseDto.setMessage("User settleup is successfully completed.");
           settleUpResponseDto.setUserId(settleUpRequestDto.getUserId());
         } catch (UserException exception) {
             settleUpResponseDto.setMessage("FAILURE");
             settleUpResponseDto.setMessage(exception.getMessage());
             settleUpResponseDto.setUserId(settleUpRequestDto.getUserId());
         }
       return settleUpResponseDto;
    }
    public SettleUpGroupRersponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto) {

         return null;
    }

}
