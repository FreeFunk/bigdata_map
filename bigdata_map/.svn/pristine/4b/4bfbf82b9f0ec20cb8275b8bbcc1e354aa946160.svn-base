package com.edgedo.common.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class IocUtil implements ApplicationContextAware
{

    private static ApplicationContext applicationContext;

    public static Object getBean(String id)
    {
        return applicationContext.getBean(id);
    }

    public static <T> T getBean(Class<T> t) {
        return applicationContext.getBean(t);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        IocUtil.applicationContext = applicationContext;
    }
}