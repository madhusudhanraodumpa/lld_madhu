package com.pattern.factory.abstractFactory.uiFrameWork.checkBox;

public class WebCheckBox implements CheckBox{
    @Override
    public void createCheckBox() {
        System.out.println("Web checkbox created..");
    }
}
