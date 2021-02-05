package com.example.springbootdemoaop.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemoaop.annotation.PermissionAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: PermissionFirstAdvice
 * @Description: 权限验证测试切面处理
 * @Author: zhangdi
 * @Date: 2020年11月07日 11:15
 **/
@Aspect
@Component
@Order(value = 1)
public class PermissionFirstAdvice {

    /**
     * 定义一个切面，括号内写入定义注解的路径
     */
    @Pointcut(value = "@annotation(com.example.springbootdemoaop.annotation.PermissionAnnotation)")
    public void perssionPoint() {

    }

    @Around(value = "perssionPoint()")
    public Object permissionFirstCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("========第一个切面==========");
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        PermissionAnnotation annotation = method.getAnnotation(PermissionAnnotation.class);
        RequestMapping annotation1 = method.getAnnotation(RequestMapping.class);
        // 获取请求参数
        Object[] args = joinPoint.getArgs();
        System.out.println("参数：" + Arrays.toString(args));

        Long id = ((JSONObject) args[0]).getLong("id");
        Object name = ((JSONObject) args[0]).get("name");
        System.out.println("id=" + id);
        System.out.println("name=" + name);

        if ("100".equals(args[0].toString())) {
            return JSON.parseObject("{\"message\":\"illegal id\",\"code\":403}");
        }

        return joinPoint.proceed();
    }
}
