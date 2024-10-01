package com.pattern.decorate.coffee;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        coffee = new WhippedCreamDecorator(coffee);
        //coffee = new CaramelDecorator(coffee);
        System.out.println(coffee.cost());
        System.out.println(coffee.description());

    }
}
