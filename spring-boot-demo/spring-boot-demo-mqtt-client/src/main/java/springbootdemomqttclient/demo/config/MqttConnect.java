package springbootdemomqttclient.demo.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: MqttConect
 * @Description: MqttConect
 * @Author: zhangdi
 * @Date: 2021年03月09日 08:55
 **/
public class MqttConnect {

    @Value("${mqtt.username}")
    private String userName;

    @Value("${mqtt.password}")
    private String password;

    /**
     * 把配置里的cleanSession设为false，客户端掉线后，服务端不会清除session，
     * 当重连后可以接收之前订阅主题的消息。
     * 当客户端上线后会接收到它离线的这段时间的消息.
     * 如果断线需要删除之前的消息，则可以设置为true.
     *
     * @return MqttConnectOptions
     */
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName("admin");
        mqttConnectOptions.setPassword("public".toCharArray());
        mqttConnectOptions.setConnectionTimeout(10);
        mqttConnectOptions.setKeepAliveInterval(20);
        return mqttConnectOptions;
    }

    /**
     * MqttConnectOptions
     *
     * @param options
     * @return MqttConnectOptions
     */
    public MqttConnectOptions getMqttConnectOptions(MqttConnectOptions options) {
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(10);
        options.setKeepAliveInterval(20);
        return options;
    }
}
