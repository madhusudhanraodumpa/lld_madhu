package com.pattern.observer.withoutObserver;

public class Client {
    public static void main(String[] args) {

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        EmailService emailService = new EmailService();
        SmsService smsService = new SmsService();
        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();
        Flipkart flipkart = new Flipkart(invoiceGenerator,emailService,smsService,inventoryManagementSystem);

        Order order= new Order();

        order.orderId=1234L;
        order.customerEmail="madhu.sudhan40@gmail.com";
        order.customerPhoneNumber="9900395337";
        order.productId=12L;

        flipkart.orderPlaced(order);


    }
}
