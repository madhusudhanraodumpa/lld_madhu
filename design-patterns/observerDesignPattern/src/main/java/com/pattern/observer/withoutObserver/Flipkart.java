package com.pattern.observer.withoutObserver;

public class Flipkart {
    private InvoiceGenerator invoiceGenerator;
    private EmailService emailService;
    private SmsService smsService;
    private InventoryManagementSystem inventoryManagementSystem;

    public Flipkart(InvoiceGenerator invoiceGenerator, EmailService emailService, SmsService smsService, InventoryManagementSystem inventoryManagementSystem) {
        this.invoiceGenerator = invoiceGenerator;
        this.emailService = emailService;
        this.smsService = smsService;
        this.inventoryManagementSystem = inventoryManagementSystem;
    }

    public void orderPlaced(Order order) {
        this.invoiceGenerator.generateInvoice();
        this.emailService.sendEmail(order.customerEmail,"Your order has been placed.");
        this.smsService.sendSMS(order.customerPhoneNumber,"Your order has been placed.");
        this.inventoryManagementSystem.update(order.productId);

    }
}
