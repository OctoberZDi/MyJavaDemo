package com.example.springbootdemoaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: PermissionSecondAdvice
 * @Description: 第二个切面
 * @Author: zhangdi
 * @Date: 2020年11月07日 14:25
 **/
@Aspect
@Component
@Order(value = 2)
public class PermissionSecondAdvice {
    @Pointcut(value = "@annotation(com.example.springbootdemoaop.annotation.PermissionAnnotation)")
    public void permissionSecondPoint() {

    }

    @Around(value = "permissionSecondPoint()")
    public Object permissionSecondCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("========第二个切面==========");

        return joinPoint.proceed();
    }
}
