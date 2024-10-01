package com.pattern.decorate.pizza1;

public class Client {
    public static void main(String[] args) {

        Pizza p =  new Paneer(new Cheese(new Tomato(new BBQChicken())));
        System.out.println(p.cost());
        System.out.println(p.description());
    }
}
