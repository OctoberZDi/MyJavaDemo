package com.example.springbootdemoaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: GettingAdvice
 * @Description: getting 切面处理:给GetMapping处理打印日志
 * @Author: zhangdi
 * @Date: 2020年11月07日 10:23
 **/
@Aspect
@Component
public class GettingAdvice {
    /**
     * 定义一个切点，被GetMapping注解修饰的方法会织入advice
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void GettintPoint() {

    }

    /**
     * before代表GettingAdvice将在目标方法执行前执行
     */
    @Before(value = "GettintPoint()")
    private void beforeGetAdvice() {

        System.out.println("Get 请求的advice被触发了！1！！！！");
    }
}
