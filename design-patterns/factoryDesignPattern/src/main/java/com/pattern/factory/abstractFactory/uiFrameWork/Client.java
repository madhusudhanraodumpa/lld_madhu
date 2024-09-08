package com.pattern.factory.abstractFactory.uiFrameWork;

import com.pattern.factory.abstractFactory.uiFrameWork.framework.*;
import com.pattern.factory.factoryMethod.uiFrameWork.button.AndroidButton;
import com.pattern.factory.factoryMethod.uiFrameWork.button.Button;

public class Client {

    public static void main(String[] args) {

        FrameWork frameWork= FrameWorkFactory.getFrameWorkByType(FrameWorkType.IOS);
//        Button button;
//
//        if(frameWork instanceof AndroidFrameWork){
//            button=new AndroidButton();
//        }

        frameWork.createUIFactory().getTextBox().createTextBox();


    }
}
