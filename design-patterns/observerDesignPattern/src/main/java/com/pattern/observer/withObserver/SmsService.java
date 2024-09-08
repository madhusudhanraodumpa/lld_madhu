package com.pattern.observer.withObserver;

public class SmsService implements OrderPlacedObserver{
    public void sendSMS(String to, String body) {
        System.out.println(
                "Sending SMS to " + to + " with body: " + body
        );
    }

    @Override
    public void orderPlaced(Order order) {
        this.sendSMS(order.customerPhoneNumber, "your order has been placed..");
    }

    public SmsService(Flipkart flipkart) {
        flipkart.orderPlacedObserverRegister(this);
    }
}
