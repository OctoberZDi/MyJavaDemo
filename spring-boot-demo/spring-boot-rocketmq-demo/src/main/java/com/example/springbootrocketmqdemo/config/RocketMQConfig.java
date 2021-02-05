package com.example.springbootrocketmqdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: RocketMQConfig
 * @Description: mq配置
 * @Author: zhangdi
 * @Date: 2020年03月30日 16:10
 **/
@Configuration
@Data
@ConfigurationProperties(prefix = "rocketmq.info")
public class RocketMQConfig {
    private String nameSvr;
    private String topic;
    private String group;
    private String instanceName;
    private String tag;
}
