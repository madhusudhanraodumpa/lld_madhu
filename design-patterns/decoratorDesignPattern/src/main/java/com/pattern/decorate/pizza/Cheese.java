package com.pattern.decorate.pizza;

public class Cheese extends PizzaDecorator{
    public Cheese(Pizza pizza){
        super(pizza);
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
