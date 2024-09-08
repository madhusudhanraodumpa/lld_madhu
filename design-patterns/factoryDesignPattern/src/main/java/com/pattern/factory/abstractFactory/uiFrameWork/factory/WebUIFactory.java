package com.pattern.factory.abstractFactory.uiFrameWork.factory;

import com.pattern.factory.abstractFactory.uiFrameWork.button.Button;
import com.pattern.factory.abstractFactory.uiFrameWork.button.WebButton;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.CheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.WebCheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.RadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.WebRadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.TextBox;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.WebTextBox;

public class WebUIFactory implements UIFactory{
    @Override
    public Button getButton() {
        return new WebButton();
    }

    @Override
    public CheckBox getCheckBox() {
        return new WebCheckBox();
    }

    @Override
    public TextBox getTextBox() {
        return new WebTextBox();
    }

    @Override
    public RadioButton getRadioButton() {
        return new WebRadioButton();
    }
}
