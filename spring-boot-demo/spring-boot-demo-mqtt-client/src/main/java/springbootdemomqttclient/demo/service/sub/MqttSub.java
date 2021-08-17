package springbootdemomqttclient.demo.service.sub;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;
import springbootdemomqttclient.demo.callback.PublishCallback;
import springbootdemomqttclient.demo.config.MqttConnect;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: MqttSub
 * @Description: sub.MqttSub
 * @Author: zhangdi
 * @Date: 2021年03月09日 09:01
 **/
@Component
public class MqttSub {

    public MqttClient client;

    private static final String SERVER_URI = "tcp://localhost:1883";
    private static final String CLIENT_ID = "testSub";

    private static final String topic = "goods";
    private final MqttConnect mqttConnect = new MqttConnect();

    /**
     * true为非持久订阅
     * <p>
     * 方法实现说明 断线重连方法，如果是持久订阅，重连是不需要再次订阅，如果是非持久订阅，重连是需要重新订阅主题 取决于options.setCleanSession(true);
     * <p>
     * 就是这里的clientId，服务器用来区分用户的，不能重复,clientId不能和发布的clientId一样，否则会出现频繁断开连接和重连的问题
     * 不仅不能和发布的clientId一样，而且也不能和其他订阅的clientId一样，如果想要接收之前的离线数据，这就需要将client的 setCleanSession
     * 设置为false，这样服务器才能保留它的session，再次建立连接的时候，它就会继续使用这个session了。 这时此连接clientId 是不能更改的。
     * 但是其实还有一个问题，就是使用热部署的时候还是会出现频繁断开连接和重连的问题，可能是因为刚启动时的连接没断开，然后热部署的时候又进行了重连，重启一	  *   下就可以了
     * System.currentTimeMillis()
     *
     * @throws MqttException
     */
    public void connect() throws MqttException {
        if (client == null) {
            MemoryPersistence memoryPersistence = new MemoryPersistence();
            client = new MqttClient(SERVER_URI, CLIENT_ID, memoryPersistence);

            // 如果是订阅者则添加回调类，发布不需要
            client.setCallback(new PublishCallback(this));
        }

        MqttConnectOptions mqttConnectOptions = mqttConnect.getMqttConnectOptions();

        // 判断是否连接。
        if (!client.isConnected()) {
            client.connect(mqttConnectOptions);
        } else {
            client.disconnect();
            client.connect(mqttConnect.getMqttConnectOptions(mqttConnectOptions));
        }
        System.out.println("连接成功!");
    }

    public void init() {
        try {
            System.out.println("Connect init...");
            connect();
            // 订阅goods消息
            subscribe(topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅某个主题，qos = 0
     *
     * @param topic topic
     */
    public void subscribe(String topic) {
        subscribe(topic, 0);
    }

    /**
     * 订阅某个主题
     *
     * @param topic topic
     * @param qos   qos
     */
    public void subscribe(String topic, int qos) {
        try {
            client.subscribe(topic, 0);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
