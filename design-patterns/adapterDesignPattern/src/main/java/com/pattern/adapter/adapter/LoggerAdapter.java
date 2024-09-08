package com.pattern.adapter.adapter;

import com.pattern.adapter.ILogger;
import com.pattern.adapter.thirdparty.logger.LoggerAPI;

public class LoggerAdapter  implements ILogger {
    LoggerAPI loggerAPI = new LoggerAPI();
    @Override
    public void log(String message) {
        loggerAPI.printLog(message.getBytes());
        System.out.println(message+" LoggerAdapter");

    }
}
