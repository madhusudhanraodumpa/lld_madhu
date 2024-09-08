package com.pattern.factory.factoryMethod.uiFrameWork.button;

public class AndroidButton implements Button{
    @Override
    public void createButton() {
        System.out.println("android button is created. ");
    }
}
