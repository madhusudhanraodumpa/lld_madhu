package com.pattern.decorate.christmasTree;

public class Client {
    public static void main(String[] args) {
        ChristmasTree ChristmasTree = new GiftsDecorator(new LightDecorator(new BellsDecorator(new SimpleChristmasTree())));
        System.out.println(ChristmasTree.makeChristmasTree());
    }
}
