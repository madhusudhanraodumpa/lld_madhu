package com.pattern.decorate.coffee;

public class WhippedCreamDecorator extends CoffeeDecorator{
    public WhippedCreamDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public int cost() {
        return this.coffee.cost() + 2;
    }

    @Override
    public String description() {
        return this.coffee.description() + " ,whipped cream";
    }
}
