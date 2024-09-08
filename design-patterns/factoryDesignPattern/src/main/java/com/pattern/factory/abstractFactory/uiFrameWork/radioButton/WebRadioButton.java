package com.pattern.factory.abstractFactory.uiFrameWork.radioButton;

public class WebRadioButton implements RadioButton{
    @Override
    public void createRadioButton() {
        System.out.println("Web radio button created..");
    }
}
