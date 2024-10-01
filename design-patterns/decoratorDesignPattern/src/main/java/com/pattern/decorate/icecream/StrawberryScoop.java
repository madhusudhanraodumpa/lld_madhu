package com.pattern.decorate.icecream;

public class StrawberryScoop implements IceCream{

    IceCream iceCream;
    public StrawberryScoop (IceCream iceCream) {
        this.iceCream = iceCream;
    }
    @Override
    public long getPrice() {
        return 35+this.iceCream.getPrice();
    }

    @Override
    public String getDescription() {
        return this.iceCream.getDescription()+" Strawberry Scoop";
    }
}
