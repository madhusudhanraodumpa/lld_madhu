package com.design.parkinglot.controller;

import com.design.parkinglot.dto.GenerateBillRequestDto;
import com.design.parkinglot.dto.GenerateBillResponseDto;
import com.design.parkinglot.dto.ResponseStatus;
import com.design.parkinglot.exception.InvalidGateException;
import com.design.parkinglot.exception.InvalidTicketException;
import com.design.parkinglot.model.Bill;
import com.design.parkinglot.service.BillingService;

public class BillController {
    private BillingService billingService;
    public BillController(BillingService billingService) {
        this.billingService = billingService;
    }

    public GenerateBillResponseDto createBill(GenerateBillRequestDto generateBillRequestDto) {
       GenerateBillResponseDto generateBillResponseDto = new GenerateBillResponseDto();
        try {
           Bill bill = billingService.createBill(
                    generateBillRequestDto.getGateId(),
                    generateBillRequestDto.getTicketId()
            );
           generateBillResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
           generateBillResponseDto.setAmount(bill.getAmount());
           generateBillResponseDto.setExitGate(bill.getGate());
           generateBillResponseDto.setEntryGate(bill.getTicket().getGate());
           generateBillResponseDto.setEntryTime(bill.getTicket().getEntryTime());
           generateBillResponseDto.setExitTime(bill.getTicket().getEntryTime());
           generateBillResponseDto.setVehicle(bill.getTicket().getVehicle());
           generateBillResponseDto.setOperatorName(bill.getOperator().getName());
           generateBillResponseDto.setTicketId(bill.getTicket().getId());
           generateBillResponseDto.setInvoiceId(bill.getId());
        } catch (InvalidGateException e) {

            generateBillResponseDto.setMessage("Invalid exit gate");
            generateBillResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return generateBillResponseDto;
        } catch (InvalidTicketException e) {
            generateBillResponseDto.setMessage("Invalid ticket.");
            generateBillResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return generateBillResponseDto;
        }
        return generateBillResponseDto;
    }
}
