package com.example.springbootdemofileuploadclient.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FeignHeadersInterceptor
 * @Description: FeignHeadersInterceptor
 * @Author: zhangdi
 * @Date: 2021年01月27日 17:43
 **/
@Configuration
public class FeignHeadersInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        HttpServletRequest request = getHttpServletRequest();
        if (Objects.isNull(request)) {
            return;
        }

        Map<String, String> headers = getHeaders(request);
        if (headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                // 把请求过来的header请求头 原样设置到feign请求头中
                // 包括token
                // 因为服务之间调用需要携带一些用户信息之类的 所以实现了Feign的RequestInterceptor拦截器复制请求头，
                // 复制的时候是所有头都复制的,可能导致Content-length长度跟body不一致. 所以只需要判断如果是Content-length就跳过
                String name = entry.getKey();
                if ("content-length".equals(name.toLowerCase())) {
                    continue;
                }
                template.header(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            // 这种方式获取的HttpServletRequest是线程安全的
            return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enums = request.getHeaderNames();
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }
}

