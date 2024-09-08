package com.pattern.factory.factoryMethod.uiFrameWork;

import com.pattern.factory.factoryMethod.uiFrameWork.framework.AndroidFrameWork;
import com.pattern.factory.factoryMethod.uiFrameWork.framework.FrameWork;
import com.pattern.factory.factoryMethod.uiFrameWork.framework.IOSFrameWork;

public class Client {

    public static void main(String[] args) {

        FrameWork frameWork=new IOSFrameWork();
        frameWork.getButton().createButton();


    }
}
