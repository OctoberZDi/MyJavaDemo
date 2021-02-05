package com.example.springbootdemo.configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LogFilter2  第二种方式：通过注解实现,需要配合ServletComponentScan
 * @Description: LogFilter2
 * @Author: zhangdi
 * @Date: 2021年02月02日 17:47
 **/
@WebFilter(urlPatterns = "/*", filterName = "logFilter2")
public class LogFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 记录执行的时间
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        System.out.println("LogFilter2 cost = " + (end - start));
    }
}
