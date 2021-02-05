package com.example.springbootdemoaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LogAop
 * @Description: log切面
 * @Author: zhangdi
 * @Date: 2020年04月08日 17:02
 **/
@Aspect
@Component
@Slf4j
public class LogAdvice {

    private static final String POINT_CUT = "";
    private static final String START_TIME = "request-start";

    /**
     * 定义切点
     */
    @Pointcut(value = "execution(public * com.example.springbootdemologaop.controller.*Controller.*(..))")
    public void log() {

    }

    @Pointcut(value = "@annotation(com.example.springbootdemoaop.annotation.Log)")
    public void log2() {

    }

    @Before("log2()")
    public void beforeLog(JoinPoint point) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("【请求 URL】：{}", request.getRequestURL());
        log.info("【请求 IP】：{}", request.getRemoteAddr());
        log.info("【请求类名】：{}，【请求方法名】：{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("【请求参数】：{}，", parameterMap);
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }

    @Around("log2()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        log.info("【返回值】：{}", result);

        return result;
    }

    /**
     * 后置操作
     */
    @AfterReturning("log2()")
    public void afterReturning() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒", end - start);

        String header = request.getHeader("User-Agent");
//        log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getPlatform().toString(), header);
    }
}
