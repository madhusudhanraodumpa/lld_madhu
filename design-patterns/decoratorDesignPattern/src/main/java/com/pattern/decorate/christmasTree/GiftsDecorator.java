package com.pattern.decorate.christmasTree;

public class GiftsDecorator extends ChristmasTreeDecorator{
    public GiftsDecorator(ChristmasTree specialChristmasTree) {
        super(specialChristmasTree);
    }


    @Override
    public String makeChristmasTree() {
        return this.christmasTree.makeChristmasTree() + addGifts();
    }

    private String addGifts() {
        return " + Gifts ";
    }
}
