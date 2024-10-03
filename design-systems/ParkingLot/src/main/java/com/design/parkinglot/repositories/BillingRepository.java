package com.design.parkinglot.repositories;

import com.design.parkinglot.model.Bill;

import java.util.Optional;

public class BillingRepository {

    private Long lastSaveId=0L;
    public Optional<Bill> save(Bill bill) {
        bill.setId(lastSaveId+1);
        lastSaveId=lastSaveId+1;
        return Optional.of(bill);
    }
}
