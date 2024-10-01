package com.pattern.decorate.icecream;

public class OrangeCone implements IceCream {
    IceCream iceCream;
    public OrangeCone (IceCream iceCream) {
        this.iceCream = iceCream;
    }
    public OrangeCone() {}
    @Override
    public long getPrice() {
        return 20 + (this.iceCream!=null ? this.iceCream.getPrice() :0L);
    }

    @Override
    public String getDescription() {
        return this.iceCream!=null ? this.iceCream.getDescription() + " orange cone" :" orange cone";
    }
}
