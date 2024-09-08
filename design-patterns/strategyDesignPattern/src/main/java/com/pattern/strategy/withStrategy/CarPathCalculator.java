package com.pattern.strategy.withStrategy;

public class CarPathCalculator implements PathCalculator{
    @Override
    public void findPath(String source, String destination) {
        System.out.println("path calculator through car..");
    }
}
