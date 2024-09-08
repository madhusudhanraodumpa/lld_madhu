package com.pattern.observer.withObserver;

public class InvoiceGenerator implements OrderPlacedObserver{
    public InvoiceGenerator(Flipkart flipkart) {
        flipkart.orderPlacedObserverRegister(this);
    }

    public void generateInvoice() {
        System.out.println("invoice generated..");
    }

    @Override
    public void orderPlaced(Order order) {
        this.generateInvoice();
    }
}
