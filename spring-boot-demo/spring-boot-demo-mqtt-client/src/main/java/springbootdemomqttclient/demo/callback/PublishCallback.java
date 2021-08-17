package springbootdemomqttclient.demo.callback;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springbootdemomqttclient.demo.service.sub.MqttSub;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: PublishCallback
 * @Description: PublishCallback
 * @Author: zhangdi
 * @Date: 2021年03月09日 09:06
 **/
public class PublishCallback implements MqttCallback {
    Logger logger = LoggerFactory.getLogger(PublishCallback.class);

    private final MqttSub mqttSub;

    public PublishCallback(MqttSub mqttSub) {
        this.mqttSub = mqttSub;
    }

    /**
     * 与服务器的连接丢失时，将调用此方法。
     *
     * @param throwable 连接丢失的原因
     */
    @Override
    public void connectionLost(Throwable throwable) {
        // 连接丢失后，在这里重连
        logger.error("---------------------连接断开，可以做重连");
        while (true) {
            try {
                // 如果没有发生异常说明连接成功，如果发生异常，则死循环
                Thread.sleep(1000);
                mqttSub.init();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 当消息从服务器到达时，将调用此方法。
     *
     * @param topic       消息主题
     * @param mqttMessage 实际消息
     * @throws Exception 发生异常后，客户端会关闭
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        // subscribe后得到的消息会执行到这里面
        String result = new String(mqttMessage.getPayload(), "UTF-8");
        System.out.println("接收消息主题 : " + topic);
        System.out.println("接收消息Qos : " + mqttMessage.getQos());
        System.out.println("接收消息内容 : " + result);
        //这里可以针对收到的消息做处理
    }

    /**
     * 消息传递完成后的调用
     *
     * @param iMqttDeliveryToken 消息传递令牌
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete---------" + iMqttDeliveryToken.isComplete());
    }
}
