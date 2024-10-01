package com.pattern.decorate.icecream;

public class ChocolateCone implements IceCream{

    IceCream iceCream;
    public ChocolateCone (IceCream iceCream) {
        this.iceCream = iceCream;
    }
    public ChocolateCone() {}

    @Override
    public long getPrice() {
        return 20+ (this.iceCream!=null ? this.iceCream.getPrice() :0L);
    }

    @Override
    public String getDescription() {
        return this.iceCream!=null ? this.iceCream.getDescription() + " Chocolate Cone" :" Chocolate Cone";

    }
}
