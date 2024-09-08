package com.pattern.factory.abstractFactory.uiFrameWork.framework;

import com.pattern.factory.abstractFactory.uiFrameWork.button.Button;
import com.pattern.factory.abstractFactory.uiFrameWork.checkBox.CheckBox;
import com.pattern.factory.abstractFactory.uiFrameWork.factory.UIFactory;
import com.pattern.factory.abstractFactory.uiFrameWork.radioButton.RadioButton;
import com.pattern.factory.abstractFactory.uiFrameWork.textBox.TextBox;

public interface FrameWork {
    UIFactory createUIFactory();
    void setTheme();
    void setReosulation();
}
