package com.pattern.factory.abstractFactory.uiFrameWork.framework;

import com.pattern.factory.abstractFactory.uiFrameWork.button.Button;
import com.pattern.factory.abstractFactory.uiFrameWork.button.IOSButton;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.CheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.IOSCheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.factory.IOSUIFactory;
import com.pattern.factory.abstractFactory.uiFrameWork.factory.UIFactory;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.IOSRadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.RadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.IOSTextBox;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.TextBox;

public class IOSFrameWork implements FrameWork {


    @Override
    public UIFactory createUIFactory() {
        return new IOSUIFactory();
    }

    @Override
    public void setTheme() {

    }

    @Override
    public void setReosulation() {

    }
}
