package com.pattern.decorate.icecream;

public class ChocolateSyrup implements IceCream{
    IceCream iceCream;
    public ChocolateSyrup (IceCream iceCream) {
        this.iceCream = iceCream;
    }
    @Override
    public long getPrice() {
        return 25+this.iceCream.getPrice();
    }

    @Override
    public String getDescription() {
        return this.iceCream.getDescription()+" Chocolate Syrup";
    }
}
