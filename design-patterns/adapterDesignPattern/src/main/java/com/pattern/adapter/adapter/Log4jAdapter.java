package com.pattern.adapter.adapter;

import com.pattern.adapter.ILogger;
import com.pattern.adapter.thirdparty.log4j.Log4JSDK;

public class Log4jAdapter  implements ILogger {
    private Log4JSDK log4J = new Log4JSDK();
    @Override
    public void log(String message) {
        log4J.sendStream(message);
        System.out.println(message+" Log4jAdapter");
    }
}
