package com.pattern.factory.abstractFactory.uiFrameWork.framework;

import com.pattern.factory.abstractFactory.uiFrameWork.button.Button;
import com.pattern.factory.abstractFactory.uiFrameWork.button.WebButton;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.CheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.WebCheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.factory.UIFactory;
import com.pattern.factory.abstractFactory.uiFrameWork.factory.WebUIFactory;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.RadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.WebRadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.TextBox;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.WebTextBox;

public class WebFrameWork implements FrameWork {


    @Override
    public UIFactory createUIFactory() {
        return new WebUIFactory();
    }

    @Override
    public void setTheme() {

    }

    @Override
    public void setReosulation() {

    }
}
