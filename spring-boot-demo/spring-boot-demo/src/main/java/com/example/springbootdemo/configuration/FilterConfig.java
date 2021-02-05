package com.example.springbootdemo.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FilterConfig
 * @Description: FilterConfig
 * @Author: zhangdi
 * @Date: 2021年02月02日 17:38
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(logFilter());
        filterFilterRegistrationBean.setName("LogFilter");
        filterFilterRegistrationBean.addUrlPatterns("/*");

        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }

    @Bean
    public LogFilter logFilter() {
        return new LogFilter();
    }
}
