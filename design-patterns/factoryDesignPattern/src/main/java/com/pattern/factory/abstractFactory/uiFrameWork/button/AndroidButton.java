package com.pattern.factory.abstractFactory.uiFrameWork.button;

public class AndroidButton implements Button {
    @Override
    public void createButton() {
        System.out.println("android button is created. ");
    }
}
