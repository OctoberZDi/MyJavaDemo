package com.example.springbootdemo.pojo;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserMain
 * @Description: 测试user
 * @Author: zhangdi
 * @Date: 2020年02月22日 20:13
 **/
public class UserMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IOException {
        // 反射获取对象，参数为类的全路径名
        Class<?> aClass = Class.forName("com.example.springbootdemo.pojo.User");
        System.out.println("#########分割符(上面是Class.forName的加载过程，下面是ClassLoader的加载过程)##########");
        ClassLoader.getSystemClassLoader().loadClass("com.example.springbootdemo.pojo.User");
        System.out.println("Class.forName加载类，会初始化该类；ClassLoader加载类不会初始化，只是把类放到VM中。");

        // 获取该类的实例 方法1
        Object instance = aClass.newInstance();

        // 获取该类的实例 方法2
        Class<?> aClass1 = ClassLoader.getSystemClassLoader().loadClass("com.example.springbootdemo.pojo.User");
        Object instance1 = aClass1.newInstance();

        //获取类的类名
        System.out.println("getName获取类的全路径类名：" + aClass.getName());
        System.out.println("getSimpleName获取类的类名：" + aClass.getSimpleName());
        System.out.println("getSuperclass：" + aClass.getSuperclass());
        System.out.println("getInterfaces：" + Arrays.toString(aClass.getInterfaces()));


        System.out.println("getMethods:获得该类所有公有的方法");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            //System.out.println(method.getName());
        }
        System.out.println("getDeclaredMethods:获得该类所有方法");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        //
        System.out.println("classloader下载文件实例 From");
        ClassLoader classLoader = aClass.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("application.properties");
        FileOutputStream outputStream = new FileOutputStream(new File("D:/test.properties"));

        System.out.println("not null");
        if (resourceAsStream != null) {
            IOUtils.copy(resourceAsStream, outputStream);
        }
        System.out.println("classloader下载文件实例 End");

        System.out.println("getFields获得所有公有的属性对象 From");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("getFields获得所有公有的属性对象 End");

        System.out.println("getDeclaredFields获得所有属性对象 From");
        Field[] fields2 = aClass.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field.getName());
        }
        System.out.println("getDeclaredFields获得所有属性对象 End");

        System.out.println("getDeclaredAnnotations返回该类所有的注解对象 From");
        Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation.annotationType() + " " + declaredAnnotation.toString());
        }
        System.out.println("getDeclaredAnnotations返回该类所有的注解对象 End");

        System.out.println("getDeclaredConstructors获得该类所有构造方法 From");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("构造方式：" + declaredConstructor.getName());
        }
        System.out.println("getDeclaredConstructors获得该类所有构造方法 End");

        System.out.println(aClass.isAnnotation() ? "isAnnotation 是注解类型" : "不是注解类型");
        System.out.println("反射方法的调用实例");
        // 反射调用方法实例
        Method setName = aClass.getMethod("setName", String.class);
        setName.invoke(instance1, "zhangdi");

        Method getName = aClass.getMethod("getName");
        getName.invoke(instance1);
    }
}
