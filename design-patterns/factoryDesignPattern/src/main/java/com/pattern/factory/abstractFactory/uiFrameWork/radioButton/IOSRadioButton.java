package com.pattern.factory.abstractFactory.uiFrameWork.radioButton;

public class IOSRadioButton implements RadioButton{
    @Override
    public void createRadioButton() {
        System.out.println("IOS radio button created..");
    }
}
