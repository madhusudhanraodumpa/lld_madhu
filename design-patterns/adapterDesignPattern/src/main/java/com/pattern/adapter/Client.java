package com.pattern.adapter;

import com.pattern.adapter.factory.LoggerType;

public class Client {
    public static void main(String[] args) {
        ApplicationCode applicationCode = new ApplicationCode(LoggerType.SLO4J);
        applicationCode.doSomething();

    }
}
