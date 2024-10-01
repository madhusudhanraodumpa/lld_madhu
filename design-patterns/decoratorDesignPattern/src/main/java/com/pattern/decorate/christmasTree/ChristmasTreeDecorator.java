package com.pattern.decorate.christmasTree;

public abstract class ChristmasTreeDecorator implements ChristmasTree{
    ChristmasTree christmasTree;
    ChristmasTreeDecorator(ChristmasTree christmasTree){
        this.christmasTree = christmasTree;
    }
}
