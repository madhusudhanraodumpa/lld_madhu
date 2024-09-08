package com.pattern.strategy.withStrategy;

public class PathCalculatorFactory {

    public static PathCalculator createPathCalculator(String strategy) {


        if(strategy.equalsIgnoreCase("car")) {
            return new CarPathCalculator();
        }
        if(strategy.equalsIgnoreCase("bike")) {
            return new BikePathCalculator();
        }
        if(strategy.equalsIgnoreCase("walk")) {
            return new WalkPathCalculator();
        }
        return null;
    }
}
