package com.pattern.decorate.pizza;

public class Paneer extends PizzaDecorator{
    public Paneer(Pizza pizza){
        super(pizza);
    }
    @Override
    public int cost() {
        return this.pizza.cost() + 60;
    }

    @Override
    public String name() {
        return "Paneer";
    }

    @Override
    public String description() {
        return this.pizza.description() +" + "+name();
    }
}
