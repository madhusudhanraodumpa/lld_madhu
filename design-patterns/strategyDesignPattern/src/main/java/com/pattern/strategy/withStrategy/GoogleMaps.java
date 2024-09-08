package com.pattern.strategy.withStrategy;

public class GoogleMaps {

    public void pathCalculate(String from,String to, String mode) {

        PathCalculator pathCalculator = PathCalculatorFactory.createPathCalculator(mode);
        pathCalculator.findPath(from,to);
    }
}
