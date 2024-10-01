package com.pattern.decorate.pizza;

public class Tomato extends PizzaDecorator{
    public Tomato(Pizza pizza){
        super(pizza);
    }
    @Override
    public int cost() {
        return this.pizza.cost() + 30;
    }

    @Override
    public String name() {
        return "Tomato";
    }

    @Override
    public String description() {
        return this.pizza.description() +" + "+name();
    }
}
