package com.pattern.decorate.pizza;

public class Margherita implements Pizza{
    @Override
    public int cost() {
        return 200;
    }

    @Override
    public String name() {
        return "Margherita";
    }

    @Override
    public String description() {
        return "Margherita";
    }
}
