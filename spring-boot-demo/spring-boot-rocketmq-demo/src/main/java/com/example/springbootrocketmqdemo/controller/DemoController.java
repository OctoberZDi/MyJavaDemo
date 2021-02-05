package com.example.springbootrocketmqdemo.controller;

import com.example.springbootrocketmqdemo.config.RocketMQConfig;
import com.example.springbootrocketmqdemo.demo.DemoProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: DemoController
 * @Description: 测试rest消息
 * @Author: zhangdi
 * @Date: 2020年03月30日 16:28
 **/
@RestController
@Slf4j
@RequestMapping(value = "demo")
public class DemoController {
    @Autowired
    DemoProducer producer;

    @Autowired
    RocketMQConfig rocketMQConfig;

    @RequestMapping(value = "test")
    public Object test() {
        List<String> msgList = new ArrayList<>();
        msgList.add("aa");
        msgList.add("bb");
        msgList.add("cc");
        msgList.add("dd");
        msgList.add("ee");
        Message message = null;
        try {
            for (String msg : msgList) {
                producer.send(msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
                log.info("输出生产者消息：" + msg);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "成功";
    }

    @RequestMapping(value = "testAsyn")
    public Object sendAsyn() {
        List<String> msgList = new ArrayList<>();
        msgList.add("11");
        msgList.add("22");
        msgList.add("33");
        msgList.add("44");
        msgList.add("55");
        for (String msg : msgList) {
            producer.sendAsyn(msg.getBytes(Charset.defaultCharset()));
        }

        return "成功";
    }
}
