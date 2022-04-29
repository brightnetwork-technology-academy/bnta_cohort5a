package org.example._3_usage;

import org.example._2_basic.LogLevel;

public class EnumUsageExamples {

    String getLogLevelMessageUsingSwitchCase(LogLevel logLevel) {
        switch (logLevel){
            case DEBUG -> {
                return "It's DEBUG!";
            }
            case INFO -> {
                return "It's INFO!";
            }
            case WARNING -> {
                return "It's WARNING!";
            }
            default -> {
                return "I don't recognize that enum!";
            }
        }
    }

    String getLogLevelMessageUsingIf(LogLevel logLevel) {
        if(logLevel == LogLevel.DEBUG) {
            return "It's DEBUG!";
        } else if(logLevel == LogLevel.INFO) {
            return "It's INFO!";
        } else if (logLevel == LogLevel.WARNING) {
            return "It's WARNING!";
        } else {
            return "I don't recognize that enum!";
        }
    }

}
