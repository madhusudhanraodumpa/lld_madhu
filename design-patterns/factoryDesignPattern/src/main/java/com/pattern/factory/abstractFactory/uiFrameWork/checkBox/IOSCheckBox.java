package com.pattern.factory.abstractFactory.uiFrameWork.checkBox;

public class IOSCheckBox implements CheckBox{
    @Override
    public void createCheckBox() {
        System.out.println("IOS checkbox created..");
    }
}
