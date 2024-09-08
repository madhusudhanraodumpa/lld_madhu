package com.pattern.observer.withObserver;

import com.pattern.observer.withObserver.Order;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {



    List<OrderPlacedObserver> orderPlacedObserverList = new ArrayList<>();

    public void orderPlacedObserverRegister(OrderPlacedObserver orderPlacedObserver) {
        this.orderPlacedObserverList.add(orderPlacedObserver);
    }
    public void orderPlacedObserverUnRegister(OrderPlacedObserver orderPlacedObserver) {
        this.orderPlacedObserverList.remove(orderPlacedObserver);
    }

    public void orderPlaced(Order order) {
        for (OrderPlacedObserver observer : orderPlacedObserverList) {
            observer.orderPlaced(order);
        }
    }
}
