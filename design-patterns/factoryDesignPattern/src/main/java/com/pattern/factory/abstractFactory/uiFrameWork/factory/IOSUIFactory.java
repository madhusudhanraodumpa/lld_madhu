package com.pattern.factory.abstractFactory.uiFrameWork.factory;

import com.pattern.factory.abstractFactory.uiFrameWork.button.Button;
import com.pattern.factory.abstractFactory.uiFrameWork.button.IOSButton;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.CheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.IOSCheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.IOSRadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.RadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.IOSTextBox;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.TextBox;

public class IOSUIFactory implements UIFactory{

    @Override
    public Button getButton() {
        return new IOSButton();
    }

    @Override
    public CheckBox getCheckBox() {
        return new IOSCheckBox();
    }

    @Override
    public TextBox getTextBox() {
        return new IOSTextBox();
    }

    @Override
    public RadioButton getRadioButton() {
        return new IOSRadioButton();
    }
}
