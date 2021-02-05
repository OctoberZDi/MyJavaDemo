package com.example.springbootdemoapiresponse.interceptor;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: WebConfig
 * @Description: webconfig
 * @Author: zhangdi
 * @Date: 2020年11月02日 19:23
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/api/**")配置拦截路径，其中/**表示当前目录以及所有子目录（递归），/*表示当前目录，不包括子目录。
        registry.addInterceptor(responseResultInterceptor).addPathPatterns("/**");
    }

    /**
     * 自定义消息转化器
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fjc = new FastJsonHttpMessageConverter();
        FastJsonConfig fj = new FastJsonConfig();
        fj.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        fjc.setFastJsonConfig(fj);
        converters.add(fjc);
        /*1、WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
        　　2、WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
        　　3、DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
        　　4、WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
        　　5、WriteMapNullValue：是否输出值为null的字段,默认为false。*/
        System.out.println("**********");
    }
}
