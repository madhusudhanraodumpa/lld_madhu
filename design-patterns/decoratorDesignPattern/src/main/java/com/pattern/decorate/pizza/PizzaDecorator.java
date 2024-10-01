package com.pattern.decorate.pizza;

public abstract class PizzaDecorator implements Pizza{
    Pizza pizza;
    public PizzaDecorator(Pizza pizza){
        this.pizza =pizza;
    }
}
