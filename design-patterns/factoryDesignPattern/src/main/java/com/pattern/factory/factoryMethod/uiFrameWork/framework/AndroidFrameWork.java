package com.pattern.factory.factoryMethod.uiFrameWork.framework;

import com.pattern.factory.factoryMethod.uiFrameWork.button.AndroidButton;
import com.pattern.factory.factoryMethod.uiFrameWork.button.Button;

public class AndroidFrameWork implements FrameWork{
    @Override
    public Button getButton() {
        return new AndroidButton();
    }

    @Override
    public void setTheme() {

    }

    @Override
    public void setReosulation() {

    }
}
