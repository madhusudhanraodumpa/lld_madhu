package com.pattern.decorate.pizza;

public class Olive extends PizzaDecorator{
    public Olive(Pizza pizza){
        super(pizza);
    }
    @Override
    public int cost() {
        return this.pizza.cost() + 20;
    }

    @Override
    public String name() {
        return "Olive";
    }

    @Override
    public String description() {
        return this.pizza.description() +" + "+name();
    }
}
