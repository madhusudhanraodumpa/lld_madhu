package com.pattern.decorate.coffee;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public int cost() {
        return this.coffee.cost() + 5;
    }

    @Override
    public String description() {
        return this.coffee.description() + " ,milk";
    }
}
