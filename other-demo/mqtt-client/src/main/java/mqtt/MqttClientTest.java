package mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.nio.charset.StandardCharsets;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: MqttClientTest
 * @Description: mqtt客户端demo
 * @Author: zhangdi
 * @Date: 2021年03月08日 11:05
 **/
public class MqttClientTest {
    public static void main(String[] args) {
        String serverURI = "tcp://localhost:1883";
        String clientId = "emqx_test";
        // 订阅主题
        String subscribeTopic = "testtopic/#";
        // 发布主题
        String publishTopic = "testtopic2/1";
        // 发布内容
        String publishContent = "Hello world,hello emqx！";

        // 服务质量
        int qos = 2;
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        try {
            MqttClient mqttClient = new MqttClient(serverURI, clientId, memoryPersistence);

            // MQTT 连接选项
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName("emqx_test");
            mqttConnectOptions.setPassword("emqx_test_password".toCharArray());
            // 保留会话
            mqttConnectOptions.setCleanSession(true);

            // 设置回调
            mqttClient.setCallback(new OnMessageCallback());

            // 建立连接
            System.out.println("Connecting to broker: " + serverURI);
            mqttClient.connect(mqttConnectOptions);

            System.out.println("Connected");
            System.out.println("Publishing message: " + publishContent);

            // 订阅消息
            mqttClient.subscribe(subscribeTopic);

            // 消息发布
            MqttMessage mqttMessage = new MqttMessage(publishContent.getBytes(StandardCharsets.UTF_8));
            // 服务质量
            mqttMessage.setQos(qos);

            mqttClient.publish(publishTopic, mqttMessage);
            System.out.println("Message published");

            // 断开连接
            mqttClient.disconnect();

            mqttClient.close();

            System.exit(0);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("exception " + me);
            me.printStackTrace();
        }
    }
}
