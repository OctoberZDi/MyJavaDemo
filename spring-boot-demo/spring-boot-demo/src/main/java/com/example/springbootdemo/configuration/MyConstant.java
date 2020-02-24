package com.example.springbootdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: springboot-demo
 * @ClassName: MyConstant
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年02月21日 14:59
 **/
@Configuration
public class MyConstant {
    /**
     * 默认的分页配置
     *
     * @return
     */
    public Map defaultPageConfig(String type) {
        System.out.println("******" + type);
        Map pageMap = new HashMap();

        if ("0".equals(type)) {
            pageMap.put("type", 0);
        } else if ("1".equals(type)) {
            pageMap.put("type", 1);

        } else {
            pageMap.put("type", null);
        }

        return pageMap;
    }
}