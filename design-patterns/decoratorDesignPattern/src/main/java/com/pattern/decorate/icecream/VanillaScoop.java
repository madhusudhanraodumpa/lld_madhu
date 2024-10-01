package com.pattern.decorate.icecream;

public class VanillaScoop implements IceCream {

    IceCream iceCream;
    public VanillaScoop (IceCream iceCream) {
        this.iceCream = iceCream;
    }
    @Override
    public long getPrice() {
        return 30+this.iceCream.getPrice();
    }

    @Override
    public String getDescription() {
        return this.iceCream.getDescription() + " Vanilla Scoop";
    }
}
