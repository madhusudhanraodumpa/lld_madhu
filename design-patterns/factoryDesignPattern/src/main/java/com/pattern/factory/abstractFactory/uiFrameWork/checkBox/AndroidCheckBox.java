package com.pattern.factory.abstractFactory.uiFrameWork.checkBox;

public class AndroidCheckBox implements CheckBox{
    @Override
    public void createCheckBox() {
        System.out.println("Android checkbox created..");
    }
}
