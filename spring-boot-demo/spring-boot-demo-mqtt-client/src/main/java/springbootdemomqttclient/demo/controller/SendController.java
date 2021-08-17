package springbootdemomqttclient.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springbootdemomqttclient.demo.data.SendData;
import springbootdemomqttclient.demo.service.ISend;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: SendController
 * @Description: SendController
 * @Author: zhangdi
 * @Date: 2021年03月08日 16:26
 **/
@RestController
@RequestMapping(value = "mqtt")
public class SendController {


    ISend send;

    @Autowired
    public void setSend(ISend send) {
        this.send = send;
    }

    @RequestMapping(value = "send", method = RequestMethod.GET)
    public void test(SendData sendData) {
        JSONObject json = (JSONObject) JSONObject.toJSON(sendData);
        System.out.println("mqtt 消息发布，使用默认主题发布:" + json.toJSONString());
        send.sendToMqtt(json.toJSONString());
    }

    /**
     * 发送自定义消息内容，且指定主题
     *
     * @param data
     */
    @RequestMapping(value = "/send/topic", method = RequestMethod.GET)
    public void test2(SendData data) {
        JSONObject json = (JSONObject) JSONObject.toJSON(data);
        System.out.println("mqtt 消息发布，指定主题:" + json.toJSONString());
        send.sendToMqtt(data.getTopic(), json.toJSONString());
    }
}
