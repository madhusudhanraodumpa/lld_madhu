package com.pattern.decorate.pizza1;



public class Cheese implements Pizza {
    public Pizza pizza;
    public Cheese(Pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public int cost() {
        return this.pizza.cost() + 80;
    }

    @Override
    public String name() {
        return "Cheese";
    }

    @Override
    public String description() {
        return this.pizza.description() +" + "+name();
    }
}
