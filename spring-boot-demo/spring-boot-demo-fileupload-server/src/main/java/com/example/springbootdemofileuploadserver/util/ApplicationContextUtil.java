package com.example.springbootdemofileuploadserver.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ApplicationContextUtil
 * @Description: application context工具类
 * @Author: zhangdi
 * @Date: 2020年11月07日 15:42
 **/
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    /**
     * 获取容器中的实例
     *
     * @param clazz 根据class获取Spring容器中对应的Bean类
     */
    public static <T> T getBean(Class<T> clazz) {
        return getContext().getBean(clazz);
    }

    public static ApplicationContext getContext() {
        return applicationContext;
    }

    public static Object getBean(String beanId) {
        return getBean(Object.class, beanId);
    }

    public static <T> T getBean(Class<T> clazz, String beanId) throws ClassCastException {
        ApplicationContext context = ApplicationContextUtil.getContext();
        boolean a = context.containsBean(beanId);
        Object bean = null;
        bean = context.getBean(beanId);
        return (T) bean;
    }
}
