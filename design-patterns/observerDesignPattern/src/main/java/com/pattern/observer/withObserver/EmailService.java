package com.pattern.observer.withObserver;

public class EmailService implements OrderPlacedObserver{

    public EmailService(Flipkart flipkart) {
        flipkart.orderPlacedObserverRegister(this);
    }
    void sendEmail(String to, String body) {
        System.out.println(
                "Sending email to " + to + " with body: " + body
        );
    }

    @Override
    public void orderPlaced(Order order) {
        this.sendEmail(order.customerEmail,"your order has been placed..");
    }
}
