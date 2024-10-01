package com.pattern.decorate.icecream;

public class Client {
    public static void main(String[] args) {

        IceCream iceCream = new VanillaScoop(new ChocolateScoop(new OrangeCone(new ChocolateCone())));

        System.out.println(iceCream.getPrice());
        System.out.println(iceCream.getDescription());

    }
}
