package com.pattern.factory.abstractFactory.uiFrameWork.textBox;

public class IOSTextBox implements TextBox{
    @Override
    public void createTextBox() {
        System.out.println("IOS text box created..");
    }
}
