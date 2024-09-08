package com.pattern.factory.abstractFactory.uiFrameWork.framework;

public class FrameWorkFactory {

    public static FrameWork getFrameWorkByType(FrameWorkType frameWorkType) {
       return switch (frameWorkType) {
            case IOS -> new IOSFrameWork();
            case ANDROID -> new AndroidFrameWork();
            case WEB -> new WebFrameWork();
        };
    }
}
