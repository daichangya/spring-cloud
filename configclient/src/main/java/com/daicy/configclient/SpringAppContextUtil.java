package com.daicy.configclient;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获得spring 上下文
 */
@Component
public class SpringAppContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContextHolder;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        initApplicationContext(applicationContext);
    }

    private static void initApplicationContext(ApplicationContext applicationContext) {
        applicationContextHolder = applicationContext;
    }

    public static <T> T getBean(Class<T> t) {
        return applicationContextHolder.getBean(t);

    }

    public static <T> T getBean(Class<T> clazz, String beanName) {
        return applicationContextHolder.getBean(beanName, clazz);
    }

    public static <T> Map<String, T> getBeanOfType(Class<T> clazz) {
        return applicationContextHolder.getBeansOfType(clazz);
    }

    public static <T> T getBean(String beanName) {
        return (T) applicationContextHolder.getBean(beanName);
    }

    public static <T> T getInstance(Class<T> tClass, T handle) {
        if (null == handle) {
            handle = getBean(tClass);
        }
        return handle;
    }

}
