package com.pattern.factory.abstractFactory.uiFrameWork.textBox;

public class AndroidTextBox implements TextBox{
    @Override
    public void createTextBox() {
        System.out.println("Android text box created..");
    }
}
