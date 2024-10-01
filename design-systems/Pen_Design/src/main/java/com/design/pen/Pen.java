package com.design.pen;

public abstract class Pen {
    public abstract void write();
    private String name;
    private String brand;
    private double price;
    private PenType penType;
    private boolean penHaveCap;
    private ColorType colorType;
}
