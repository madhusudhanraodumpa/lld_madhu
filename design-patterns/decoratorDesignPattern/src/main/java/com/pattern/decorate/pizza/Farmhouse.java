package com.pattern.decorate.pizza;

public class Farmhouse implements Pizza{
    @Override
    public int cost() {
        return 150;
    }

    @Override
    public String name() {
        return "Farmhouse";
    }

    @Override
    public String description() {
        return "Farmhouse";
    }
}
