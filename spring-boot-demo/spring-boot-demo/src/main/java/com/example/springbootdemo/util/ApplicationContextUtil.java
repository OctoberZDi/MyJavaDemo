package com.example.springbootdemo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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

    public static ApplicationContext getContext() {
        return applicationContext;
    }

    public static Object getBean(String beanId) {
        return getBean(Object.class, beanId);
    }

    public static <T> T getBean(Class<T> clazz, String beanId) throws ClassCastException {
        ApplicationContext context = ApplicationContextUtil.getContext();
//        Assert.isTrue(StringUtils.hasText(beanId), "beanId must not null!", true);
        boolean a = context.containsBean(beanId);
//        Assert.isTrue(context.containsBean(beanId), "beanId :[" + beanId + "] is not exist!", true);
        Object bean = null;
        bean = context.getBean(beanId);
        return (T) bean;
    }
}
