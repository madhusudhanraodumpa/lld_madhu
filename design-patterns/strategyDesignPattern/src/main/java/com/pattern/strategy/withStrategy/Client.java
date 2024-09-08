package com.pattern.strategy.withStrategy;


public class Client {
    public static void main(String[] args) {
        GoogleMaps googleMaps = new GoogleMaps();
        googleMaps.pathCalculate("hyd","palasa","bike");
    }
}
