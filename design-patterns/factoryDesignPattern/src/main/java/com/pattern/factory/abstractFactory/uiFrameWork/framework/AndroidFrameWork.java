package com.pattern.factory.abstractFactory.uiFrameWork.framework;

import com.pattern.factory.abstractFactory.uiFrameWork.button.AndroidButton;
import com.pattern.factory.abstractFactory.uiFrameWork.button.Button;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.AndroidCheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.CheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.factory.AndroidUIFactory;
import com.pattern.factory.abstractFactory.uiFrameWork.factory.UIFactory;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.AndroidRadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.RadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.AndroidTextBox;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.TextBox;

public class AndroidFrameWork implements FrameWork {


    @Override
    public UIFactory createUIFactory() {
        return new AndroidUIFactory();
    }

    @Override
    public void setTheme() {

    }

    @Override
    public void setReosulation() {

    }
}
