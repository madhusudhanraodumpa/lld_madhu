package com.pattern.decorate.christmasTree;

public class BellsDecorator extends ChristmasTreeDecorator{

    BellsDecorator(ChristmasTree christmasTree){
        super(christmasTree);
    }
    @Override
    public String makeChristmasTree() {
        return this.christmasTree.makeChristmasTree() + addBells();
    }

    private String addBells() {
        return " + Ringing Bells";
    }
}
