package com.pattern.decorate.coffee;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public int cost() {
        return this.coffee.cost() + 2;
    }

    @Override
    public String description() {
        return this.coffee.description() + " ,sugar";
    }
}
