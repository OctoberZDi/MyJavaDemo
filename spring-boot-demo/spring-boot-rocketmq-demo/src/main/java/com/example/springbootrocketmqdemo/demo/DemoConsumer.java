package com.example.springbootrocketmqdemo.demo;

import com.example.springbootrocketmqdemo.config.RocketMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: DemoConsumer
 * @Description: demo消费者
 * @Author: zhangdi
 * @Date: 2020年03月30日 16:19
 **/
@Slf4j
@Component
public class DemoConsumer {
    @Resource
    RocketMQConfig rocketMQConfig;
    private DefaultMQPushConsumer defaultMQPushConsumer;
    private static final String CONSUMER_GOURP = "consumerGroupName";

    @PostConstruct
    public void initConsumer() {
        log.info("初始化DefaultMQPushConsumer 开始");
        defaultMQPushConsumer = new DefaultMQPushConsumer(CONSUMER_GOURP);
        defaultMQPushConsumer.setNamesrvAddr(rocketMQConfig.getNameSvr());
        //消费模式:一个新的订阅组第一次启动从队列的最后位置开始消费 后续再启动接着上次消费的进度开始消费
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //订阅主题和 标签（ * 代表所有标签)下信息
        try {
            defaultMQPushConsumer.subscribe(rocketMQConfig.getTopic(), "*");
            // 注册消费的监听 并在此监听中消费信息，并返回消费的状态信息
            defaultMQPushConsumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
                // msgs中只收集同一个topic，同一个tag，并且key相同的message
                // 会把不同的消息分别放置到不同的队列中
                try {
                    for (Message msg : msgs) {

                        //消费者获取消息 这里只输出 不做后面逻辑处理
                        String body = new String(msg.getBody(), "utf-8");
                        log.info("Consumer-获取消息-主题topic为={}, 消费消息为={}", msg.getTopic(), body);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                log.info("初始化DefaultMQPushConsumer 成功");
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            // 启动消费者
            defaultMQPushConsumer.start();
            log.info("初始化DefaultMQPushConsumer 启动成功");
        } catch (MQClientException e) {
            log.info("初始化DefaultMQPushConsumer 启动失败");
            e.printStackTrace();
        }
    }
}
