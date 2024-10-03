package com.design.parkinglot.service;

import com.design.parkinglot.exception.InvalidGateException;
import com.design.parkinglot.exception.InvalidTicketException;
import com.design.parkinglot.model.*;
import com.design.parkinglot.repositories.BillingRepository;
import com.design.parkinglot.repositories.GateRepository;
import com.design.parkinglot.repositories.TicketRepository;
import com.design.parkinglot.strategies.feesCalculatoryStrategy.FeeCalculatorStrategy;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BillingService {
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private FeeCalculatorStrategy feeCalculatorStrategy;
    private BillingRepository billingRepository;
    public BillingService(GateRepository gateRepository,
                          TicketRepository ticketRepository,
                          FeeCalculatorStrategy feeCalculatorStrategy,
                          BillingRepository billingRepository) {
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.feeCalculatorStrategy = feeCalculatorStrategy;
        this.billingRepository = billingRepository;
    }


    public Bill createBill(Long gateId, Long ticketId) throws InvalidGateException, InvalidTicketException {


        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if(optionalGate.isEmpty()) {
            throw  new InvalidGateException();
        }
        Gate gate = optionalGate.get();
        Operator operator = gate.getOperator();

        Optional<Ticket> ticketOptional = ticketRepository.getTicketById(ticketId);
        if(ticketOptional.isEmpty()) {
            throw new InvalidTicketException();
        }
        Ticket ticket = ticketOptional.get();

        int amount = feeCalculatorStrategy.calculateFees(ticket.getVehicle().getVehicleType(),ticket.getEntryTime(),new Date());

        Payment payment = new Payment();
        payment.setPaymentMode(PaymentMode.CASH);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        payment.setAmount(Long.valueOf(amount));
        payment.setRefId("jkahsdg123");
        payment.setPaymentTime(new Date());
        payment.setCreatedAt(new Date());
        payment.setCreatedBy(operator.getName());





        List<Payment> paymentList = List.of(payment);

        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setCreatedBy(operator.getName());
        bill.setExitTime(new Date());
        bill.setPaymentList(paymentList);
        bill.setGate(gate);
        bill.setTicket(ticket);
        bill.setOperator(operator);
        bill.setPaymentLink("hkagd");

        Optional<Bill> billOptional = billingRepository.save(bill);
        if(billOptional.isEmpty()) {
            throw new RuntimeException();
        }
        return billOptional.get();



    }
}
