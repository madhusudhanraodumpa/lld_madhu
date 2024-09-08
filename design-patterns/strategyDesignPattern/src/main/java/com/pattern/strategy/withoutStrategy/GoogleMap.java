package com.pattern.strategy.withoutStrategy;

public class GoogleMap {

    public  void pathCalculator(String from,String to, String mode) {

        if(mode.equalsIgnoreCase("car")) {
            System.out.println("path calculator through car.");
        }
       else if(mode.equalsIgnoreCase("bike")) {
            System.out.println("path calculator through bike.");
        }
        else if(mode.equalsIgnoreCase("walk")) {
            System.out.println("path calculator through walk.");
        }
        else if(mode.equalsIgnoreCase("bus")) {
            System.out.println("path calculator through bus.");
        }
        else {
            System.out.println("default calculator...");
        }

    }
}
