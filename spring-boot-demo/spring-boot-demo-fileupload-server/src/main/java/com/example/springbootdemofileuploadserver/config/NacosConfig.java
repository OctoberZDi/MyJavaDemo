package com.example.springbootdemofileuploadserver.config;

import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import com.example.springbootdemofileuploadserver.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: NacosConfig
 * war包无法注册nacos
 * @Description: config.NacosConfig实现ApplicationRunner接口，在应用启动成功后完成某些初始化工作。
 * @Author: zhangdi
 * @Date: 2021年01月27日 11:12
 **/
@Component
public class NacosConfig implements ApplicationRunner {

    @Value("${server.port}")
    Integer port;

    @Override
    public void run(ApplicationArguments args) {
        NacosAutoServiceRegistration registration = (NacosAutoServiceRegistration) ApplicationContextUtil.getBean(NacosAutoServiceRegistration.class);
        if (registration != null && port != null) {
            System.out.println("***here***");
            registration.setPort(port);
            registration.start();
        }
    }
}
