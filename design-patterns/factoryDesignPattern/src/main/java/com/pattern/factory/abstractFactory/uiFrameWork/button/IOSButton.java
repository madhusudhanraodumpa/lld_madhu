package com.pattern.factory.abstractFactory.uiFrameWork.button;

public class IOSButton implements Button {
    @Override
    public void createButton() {
        System.out.println("IOS button is created. ");
    }
}
