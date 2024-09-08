package com.pattern.factory.abstractFactory.uiFrameWork.factory;

import com.pattern.factory.abstractFactory.uiFrameWork.button.AndroidButton;
import com.pattern.factory.abstractFactory.uiFrameWork.button.Button;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.AndroidCheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.CheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.AndroidRadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.RadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.AndroidTextBox;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.TextBox;

public class AndroidUIFactory implements UIFactory{
    @Override
    public Button getButton() {
        return new AndroidButton();
    }

    @Override
    public CheckBox getCheckBox() {
        return new AndroidCheckBox();
    }

    @Override
    public TextBox getTextBox() {
        return new AndroidTextBox();
    }

    @Override
    public RadioButton getRadioButton() {
        return new AndroidRadioButton();
    }
}
