package com.pattern.factory.abstractFactory.uiFrameWork.factory;

import com.pattern.factory.abstractFactory.uiFrameWork.button.Button;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.CheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.RadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.TextBox;

public interface UIFactory {
    Button getButton();
    CheckBox getCheckBox();
    TextBox getTextBox();
    RadioButton getRadioButton();
}
