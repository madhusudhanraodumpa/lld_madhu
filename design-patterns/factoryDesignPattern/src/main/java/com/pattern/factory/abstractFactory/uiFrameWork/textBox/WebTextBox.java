package com.pattern.factory.abstractFactory.uiFrameWork.textBox;

public class WebTextBox implements TextBox{
    @Override
    public void createTextBox() {
        System.out.println("Web text box created..");
    }
}
