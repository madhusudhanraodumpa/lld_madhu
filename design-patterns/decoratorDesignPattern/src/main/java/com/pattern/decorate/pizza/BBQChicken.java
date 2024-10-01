package com.pattern.decorate.pizza;

public class BBQChicken implements Pizza{
    @Override
    public int cost() {
        return 200;
    }

    @Override
    public String name() {
        return "BBQChicken";
    }

    @Override
    public String description() {
        return "BBQChicken";
    }
}
