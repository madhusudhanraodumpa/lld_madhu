package com.pattern.decorate.coffee;

public class SimpleCoffee implements Coffee{
    @Override
    public int cost() {
        return 40;
    }

    @Override
    public String description() {
        return "SimpleCoffee";
    }
}
