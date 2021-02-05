package com.example.springbootdemo.configuration;

import com.example.springbootdemo.annotation.LoginRequired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ProjectName: model-parent
 * @ClassName: HttpInterceptorConfig
 * @Description: 测试拦截器
 * @Author: zhangdi
 * @Date: 2020年06月11日 16:40
 **/
public class HttpInterceptorConfig extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拦截注解
        Method method = ((HandlerMethod) handler).getMethod();
        LoginRequired methodAnnotation = ((HandlerMethod) handler).getMethodAnnotation(LoginRequired.class);

        if (Objects.isNull(methodAnnotation)) {
            System.out.println("没有注解！！！！！");
            // false 拦截
            return true;
        }
        System.out.println("请求:" + request.getRequestURL());
        System.out.println("方法名字：" + method.getName());
        boolean annotationPresent = method.isAnnotationPresent(LoginRequired.class);
        if (annotationPresent) {
            System.out.println("被 LoginRequired 注解了");
            LoginRequired annotation = method.getAnnotation(LoginRequired.class);

            System.out.println("注解 loginSuccess =" + annotation.loginSuccess());
            System.out.println("注解 userIds =" + Arrays.stream(annotation.userIds()).collect(Collectors.joining(",")));
        } else {
            System.out.println("没被 LoginRequired 注解");
        }
        System.out.println("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
