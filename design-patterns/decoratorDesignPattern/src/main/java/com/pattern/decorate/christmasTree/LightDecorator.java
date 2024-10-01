package com.pattern.decorate.christmasTree;

public class LightDecorator extends ChristmasTreeDecorator{

    public LightDecorator(ChristmasTree specialChristmasTree) {
        super(specialChristmasTree);
    }

    @Override
    public String makeChristmasTree() {
        return this.christmasTree.makeChristmasTree() + addLight();
    }

    private String addLight() {
        return " + Twinkling lights";
    }
}
