package com.pattern.factory.factoryMethod.uiFrameWork.button;

public class IOSButton implements Button{
    @Override
    public void createButton() {
        System.out.println("IOS button is created. ");
    }
}
