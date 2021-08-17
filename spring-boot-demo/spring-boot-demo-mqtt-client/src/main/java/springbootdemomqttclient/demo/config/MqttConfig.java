package springbootdemomqttclient.demo.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.util.StringUtils;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: MqttConfig
 * @Description: MqttConfig
 * @Author: zhangdi
 * @Date: 2021年03月08日 15:34
 **/
@Configuration
public class MqttConfig {
    /**
     * 发布的bean名称
     */
    public static final String CHANNEL_NAME_OUT = "mqttOutboundChannel";

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.url}")
    private String url;

    @Value("${mqtt.sender.clientId}")
    private String clientId;

    @Value("${mqtt.sender.defaultTopic}")
    private String defaultTopic;

    /**
     * 客户端与服务器之间的连接意外中断，服务器将发布客户端的"遗嘱"消息
     */
    private static final byte[] WILL_DATA;

    static {
        // 遗嘱消息
        WILL_DATA = "offline".getBytes();
    }

    /**
     * MqttConnectOptions
     *
     * @return MqttConnectOptions
     */
    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        // 连接用户名
        if (!StringUtils.isEmpty(username)) {
            mqttConnectOptions.setUserName(username);
        }
        // 连接密码
        mqttConnectOptions.setPassword(password.toCharArray());
        // 连接地址
        mqttConnectOptions.setServerURIs(url.split(","));
        // 超时时间 秒
        mqttConnectOptions.setConnectionTimeout(10);
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线
        // 但这个方法并没有重连的机制
        mqttConnectOptions.setKeepAliveInterval(20);
        // 设置 遗嘱 消息的话题，若客户端与服务器之间的链接意外终端，服务器将发布客户端的遗嘱消息
        mqttConnectOptions.setWill("willTopic", WILL_DATA, 2, false);
        return mqttConnectOptions;
    }

    /**
     * MqttPahoClientFactory
     *
     * @return MqttPahoClientFactory
     */
    @Bean
    public MqttPahoClientFactory mqttPahoClientFactory() {
        DefaultMqttPahoClientFactory defaultMqttPahoClientFactory = new DefaultMqttPahoClientFactory();
        defaultMqttPahoClientFactory.setConnectionOptions(mqttConnectOptions());
        return defaultMqttPahoClientFactory;
    }

    /**
     * MQTT信息通道（生产者）
     *
     * @return MessageChannel
     */
    @Bean(name = CHANNEL_NAME_OUT)
    public MessageChannel messageChannel() {
        return new DirectChannel();
    }

    /**
     * MQTT消息处理器（生产者）
     * @ServiceActivator注解表明当前方法用于处理MQTT消息，inputChannel参数指定了用于接收消息信息的channel。
     * @return MessageHandler MessageHandler
     */
    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_OUT)
    public MessageHandler messageHandler() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId, mqttPahoClientFactory());
        // 如果设置成true，发送消息时将不会阻塞。
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(defaultTopic);
        return messageHandler;
    }
}
