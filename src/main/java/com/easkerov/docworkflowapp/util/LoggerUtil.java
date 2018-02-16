package com.easkerov.docworkflowapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

    public static Logger getLogger(Class clazz){
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * Helper method to log Controller activities
     * @param logger
     * @param logLevel
     * @param methodName
     * @param httpRequestMethod
     * @param mappingUri
     * @param info
     */
    public static void logActivity (Logger logger,
                                    String logLevel,
                                    String methodName,
                                    String httpRequestMethod,
                                    String mappingUri,
                                    String info) {

        StringBuilder msg = new StringBuilder();
        msg.append(" URI Path: " + mappingUri);
        msg.append(" HTTP Verb: " + httpRequestMethod);
        msg.append(" Method: " + methodName);
        msg.append(" Info: " + info);

        switch (logLevel) {
            case "debug":
                logger.debug(msg.toString());
                break;
        }
    }
}
