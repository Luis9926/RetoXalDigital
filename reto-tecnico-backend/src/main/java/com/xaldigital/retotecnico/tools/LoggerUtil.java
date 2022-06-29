package com.xaldigital.retotecnico.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    private static void logMessage(String message){
        logger.debug(message);
    }

}
