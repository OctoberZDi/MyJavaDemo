package com.example.springbootrocketmqdemo.demo;

import com.example.springbootrocketmqdemo.config.RocketMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: DemoProducer
 * @Description: 生产者
 * @Author: zhangdi
 * @Date: 2020年03月30日 16:04
 **/
@Slf4j
@Component // 注册为组件
public class DemoProducer {
    private DefaultMQProducer defaultMQProducer;

    @Resource
    RocketMQConfig rocketMQConfig;

    @PostConstruct
    public void initProducer() {
        log.info("初始化 DefaultMQProducer");
        defaultMQProducer = new DefaultMQProducer(rocketMQConfig.getGroup());
        defaultMQProducer.setNamesrvAddr(rocketMQConfig.getNameSvr());
        defaultMQProducer.setInstanceName(rocketMQConfig.getInstanceName());
        try {
            defaultMQProducer.start();
            log.error("defaultMQProducer 启动成功！{}", defaultMQProducer.getProducerGroup());
        } catch (MQClientException e) {
            log.error("defaultMQProducer 启动失败！{}", e.getErrorMessage());
            e.printStackTrace();
        }
    }

    public DefaultMQProducer getDefaultMQProducer() {
        return this.defaultMQProducer;
    }

    /**
     * 同步发送消息
     *
     * @param body
     */
    public void send(byte[] body) {
        Message message = new Message();
        message.setTopic(rocketMQConfig.getTopic());
        message.setTags(rocketMQConfig.getTag());
        message.setBody(body);
        try {
            this.defaultMQProducer.send(message);
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步发送消息
     *
     * @param body
     */
    public void sendAsyn(byte[] body) {
        Message message = new Message();
        message.setTopic(rocketMQConfig.getTopic());
        message.setTags(rocketMQConfig.getTag());
        message.setBody(body);
        log.info("发送异步消息=======: {}", message);
        try {
            this.defaultMQProducer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("发送异步消息=======成功: {},sendResult={}", message.getBody(), sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    log.error("发送异步消息=======失败====={}", throwable.getMessage());
                }
            });
        } catch (MQClientException | RemotingException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
