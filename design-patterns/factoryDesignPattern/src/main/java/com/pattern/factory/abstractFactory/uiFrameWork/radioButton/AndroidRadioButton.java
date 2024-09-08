package com.pattern.factory.abstractFactory.uiFrameWork.radioButton;

public class AndroidRadioButton implements RadioButton{
    @Override
    public void createRadioButton() {
        System.out.println("Android radio button created..");
    }
}
