package org.example.model;

public class Parrot extends Bird implements Flyable {
    @Override
    public void makeSound() {
        System.out.println(this.getName() + "is making sound");
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + "is  eating");

    }

    @Override
    public void walk() {
        System.out.println(this.getName() + "is  walking");
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " is  flying");
    }
}
