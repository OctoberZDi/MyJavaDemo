package com.example.springbootdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: model-parent
 * @ClassName: InterceptorConfig
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年06月11日 16:42
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((new HttpInterceptorConfig())).addPathPatterns("/**");
    }
}
