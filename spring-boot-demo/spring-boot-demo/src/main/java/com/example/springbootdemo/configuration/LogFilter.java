package com.example.springbootdemo.configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LogFilter 第一种方式：通过配置类FilterRegistrationBean 注册
 * @Description: LogFilter
 * @Author: zhangdi
 * @Date: 2021年02月02日 17:37
 **/
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 记录执行的时间
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        System.out.println("LogFilter cost = " + (end - start));
    }

    @Override
    public void destroy() {

    }
}
