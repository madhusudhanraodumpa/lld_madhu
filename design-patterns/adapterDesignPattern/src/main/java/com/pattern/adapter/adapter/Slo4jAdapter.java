package com.pattern.adapter.adapter;

import com.pattern.adapter.ILogger;
import com.pattern.adapter.thirdparty.slo4j.LoggingAPI4J;

public class Slo4jAdapter  implements ILogger {

    LoggingAPI4J loggingAPI4J = new LoggingAPI4J();
    @Override
    public void log(String message) {
        loggingAPI4J.out(message);
        System.out.println(message+" Slo4jAdapter");
    }
}
