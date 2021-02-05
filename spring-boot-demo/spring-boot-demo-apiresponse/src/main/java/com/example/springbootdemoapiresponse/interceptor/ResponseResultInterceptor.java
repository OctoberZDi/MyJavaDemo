package com.example.springbootdemoapiresponse.interceptor;

import com.example.springbootdemoapiresponse.annoation.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ResponseResultInterceptor
 * @Description: 拦截器，解析ResponseResult注解
 * @Author: zhangdi
 * @Date: 2020年11月02日 17:59
 **/
@Component
public class ResponseResultInterceptor extends HandlerInterceptorAdapter {
    public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandle");
        if (handler instanceof HandlerMethod) {
            // 请求的方法
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = ((HandlerMethod) handler).getMethod();

            // 判断是否在类对象上加了注解
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                // 设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
                request.setAttribute("RESPONSE_RESULT_ANN", clazz.getAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                // 设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
                request.setAttribute("RESPONSE_RESULT_ANN", method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
