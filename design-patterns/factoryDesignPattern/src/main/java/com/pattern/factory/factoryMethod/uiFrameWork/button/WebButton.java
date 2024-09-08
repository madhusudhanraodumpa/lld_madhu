package com.pattern.factory.factoryMethod.uiFrameWork.button;

public class WebButton implements Button{
    @Override
    public void createButton() {
        System.out.println("Web button is created. ");
    }
}
