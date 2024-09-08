package com.pattern.factory.factoryMethod.uiFrameWork.framework;

import com.pattern.factory.factoryMethod.uiFrameWork.button.AndroidButton;
import com.pattern.factory.factoryMethod.uiFrameWork.button.Button;
import com.pattern.factory.factoryMethod.uiFrameWork.button.WebButton;

public class WebFrameWork implements FrameWork{
    @Override
    public Button getButton() {
        return new WebButton();
    }

    @Override
    public void setTheme() {

    }

    @Override
    public void setReosulation() {

    }
}
