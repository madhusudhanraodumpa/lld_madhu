package com.pattern.adapter;

import com.pattern.adapter.adapter.LoggerAdapter;
import com.pattern.adapter.factory.LoggerFactory;
import com.pattern.adapter.factory.LoggerType;

public class ApplicationCode {

    ILogger iLogger;

    public ApplicationCode(LoggerType loggerType) {
       this.iLogger= LoggerFactory.createLoggerType(loggerType);
    }

    public void doSomething(){
        iLogger.log("Print hello log message");

    }

}
