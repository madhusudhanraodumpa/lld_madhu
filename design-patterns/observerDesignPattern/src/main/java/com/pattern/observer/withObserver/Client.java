package com.pattern.observer.withObserver;

import com.pattern.observer.withObserver.Order;

public class Client {
    public static void main(String[] args) {
//        EmailService emailService = new EmailService();
//        SmsService smsService = new SmsService();
//        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();
//        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
//
//        Flipkart flipkart = new Flipkart();
//        flipkart.orderPlacedObserverRegister(emailService);
//        flipkart.orderPlacedObserverRegister(smsService);
//        flipkart.orderPlacedObserverRegister(invoiceGenerator);
//        flipkart.orderPlacedObserverRegister(inventoryManagementSystem);
        Flipkart flipkart = new Flipkart();

        EmailService emailService = new EmailService(flipkart);
       SmsService smsService = new SmsService(flipkart);
        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem(flipkart);
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(flipkart);

        Order order = new Order();
        order.orderId=1234L;
        order.customerEmail="madhu.sudhan40@gmail.com";
        order.customerPhoneNumber="9900395337";
        order.productId=12L;
        flipkart.orderPlaced(order);


    }
}
