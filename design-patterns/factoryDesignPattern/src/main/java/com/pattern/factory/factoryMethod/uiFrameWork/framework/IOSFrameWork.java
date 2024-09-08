package com.pattern.factory.factoryMethod.uiFrameWork.framework;

import com.pattern.factory.factoryMethod.uiFrameWork.button.AndroidButton;
import com.pattern.factory.factoryMethod.uiFrameWork.button.Button;
import com.pattern.factory.factoryMethod.uiFrameWork.button.IOSButton;

public class IOSFrameWork implements FrameWork{
    @Override
    public Button getButton() {
        return new IOSButton();
    }

    @Override
    public void setTheme() {

    }

    @Override
    public void setReosulation() {

    }
}
