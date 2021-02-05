package com.example.springclouddemofeign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FeignConfig
 * @Description: 拦截器转发headers
 * @Author: zhangdi
 * @Date: 2020年05月23日 10:13
 **/
@Configuration
public class FeignConfigRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 线程安全的方式获取httpServletRequest
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (null != headerNames) {
            System.out.println("=================feign自定义拦截器拦截的消息头信息=================");
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                System.out.println(headerName + ":" + headerValue);

                requestTemplate.header(headerName, headerValue);
            }
        }
    }
}
