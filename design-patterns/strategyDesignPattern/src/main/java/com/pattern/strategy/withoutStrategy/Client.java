package com.pattern.strategy.withoutStrategy;

public class Client {
    public static void main(String[] args) {
        GoogleMap googleMap = new GoogleMap();
        googleMap.pathCalculator("hyd","palasa","bike");
    }
}
