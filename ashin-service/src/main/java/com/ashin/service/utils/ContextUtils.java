package com.ashin.service.utils;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class ContextUtils {
    private static ApplicationContext applicationContext;

    private ContextUtils() {
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        Class var1 = ContextUtils.class;
        synchronized(ContextUtils.class) {
            LoggerUtils.debug("setApplicationContext, notifyAll", ContextUtils.class);
            ContextUtils.applicationContext = applicationContext;
            ContextUtils.class.notifyAll();
        }
    }

    public static ApplicationContext getApplicationContext() {
        Class var0 = ContextUtils.class;
        synchronized(ContextUtils.class) {
            while(applicationContext == null) {
                try {
                    LoggerUtils.debug("getApplicationContext, wait...", ContextUtils.class);
                    ContextUtils.class.wait(60000L);
                    if (applicationContext == null) {
                        LoggerUtils.warn("Have been waiting for ApplicationContext to be set for 1 minute", null, ContextUtils.class);
                    }
                } catch (InterruptedException var3) {
                    Thread.currentThread().interrupt();
                    LoggerUtils.debug("getApplicationContext, wait interrupted", var3, ContextUtils.class);
                }
            }

            return applicationContext;
        }
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static Class<?> getType(String name) {
        return getApplicationContext().getType(name);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return getApplicationContext().getBeansOfType(type);
    }

    public static <T> T getBeanOfType(Class<T> type) {
        Map<String, T> beans = getBeansOfType(type);
        if (beans.size() == 0) {
            throw new NoSuchBeanDefinitionException(type, "Unsatisfied dependency of type [" + type + "]: expected at least 1 matching bean");
        } else if (beans.size() > 1) {
            throw new NoSuchBeanDefinitionException(type, "expected single matching bean but found " + beans.size() + ": " + beans.keySet());
        } else {
            return beans.values().iterator().next();
        }
    }
}
