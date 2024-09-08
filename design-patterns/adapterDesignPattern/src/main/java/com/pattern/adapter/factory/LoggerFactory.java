package com.pattern.adapter.factory;

import com.pattern.adapter.ILogger;
import com.pattern.adapter.adapter.Log4jAdapter;
import com.pattern.adapter.adapter.LoggerAdapter;
import com.pattern.adapter.adapter.Slo4jAdapter;

public class LoggerFactory {

    public static ILogger createLoggerType(LoggerType loggerType) {
        return switch (loggerType){
            case LOGGER -> new LoggerAdapter();
            case LOG4J -> new Log4jAdapter();
            case SLO4J -> new Slo4jAdapter();
        };

    }
}
