package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.util.ClassUtil;

import java.util.Set;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ClassUtil
 * @Description: ClassUtil
 * @Author: zhangdi
 * @Date: 2020年02月15日 14:17
 **/
public class ClassUtilDemo {
    public static void main(String[] args) {
        System.out.println(ClassUtil.getPackage(ClassUtilDemo.class));
        final Set<Class<?>> classes = ClassUtil.scanPackage();
        for (Class<?> aClass : classes) {
            System.out.println(aClass.getClass().getName());
        }
    }
}
