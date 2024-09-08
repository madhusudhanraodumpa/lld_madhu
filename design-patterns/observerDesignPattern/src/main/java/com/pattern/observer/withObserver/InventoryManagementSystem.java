package com.pattern.observer.withObserver;

public class InventoryManagementSystem implements OrderPlacedObserver{

    public InventoryManagementSystem(Flipkart flipkart) {
        flipkart.orderPlacedObserverRegister(this);
    }

    public void update(Long productId) {
        System.out.println("InventoryManagementSystem: Order is placed. Updating inventory.");
    }

    @Override
    public void orderPlaced(Order order) {
        this.update(order.productId);
    }
}
