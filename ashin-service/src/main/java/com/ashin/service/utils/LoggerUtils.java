package com.ashin.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {
    private LoggerUtils() {
    }

    public static void debug(String message, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }

    }

    public static void debug(String message, Throwable e, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isDebugEnabled()) {
            logger.debug(message, e);
        }

    }

    public static void debug(String format, Class<?> clazz, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isDebugEnabled()) {
            logger.debug(format, arguments);
        }

    }

    public static void info(String message, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }

    }

    public static void info(String message, Throwable e, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isInfoEnabled()) {
            logger.info(message, e);
        }

    }

    public static void info(String format, Class<?> clazz, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isInfoEnabled()) {
            logger.info(format, arguments);
        }

    }

    public static void warn(String message, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isWarnEnabled()) {
            logger.warn(message);
        }

    }

    public static void warn(String message, Throwable e, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isWarnEnabled()) {
            logger.warn(message, e);
        }

    }

    public static void warn(String format, Class<?> clazz, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isWarnEnabled()) {
            logger.warn(format, arguments);
        }

    }

    public static void error(String message, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }

    }

    public static void error(String message, Throwable e, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isErrorEnabled()) {
            logger.error(message, e);
        }

    }

    public static void error(String format, Class<?> clazz, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(getLoggerClazz(clazz));
        if (logger.isErrorEnabled()) {
            logger.error(format, arguments);
        }

    }

    private static Class<?> getLoggerClazz(Class<?> clazz) {
        return null == clazz ? LoggerUtils.class : clazz;
    }
}
