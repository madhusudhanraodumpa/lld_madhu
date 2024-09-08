package com.pattern.factory.abstractFactory.uiFrameWork.button;

public class WebButton implements Button {
    @Override
    public void createButton() {
        System.out.println("Web button is created. ");
    }
}
