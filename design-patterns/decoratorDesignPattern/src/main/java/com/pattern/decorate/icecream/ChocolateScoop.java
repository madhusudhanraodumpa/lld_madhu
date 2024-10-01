package com.pattern.decorate.icecream;

public class ChocolateScoop implements IceCream {

    IceCream iceCream;
    public ChocolateScoop (IceCream iceCream) {
        this.iceCream = iceCream;
    }
    @Override
    public long getPrice() {
        return 40 + iceCream.getPrice();
    }

    @Override
    public String getDescription() {
        return this.iceCream.getDescription() +" chocolate Scoop";
    }
}
