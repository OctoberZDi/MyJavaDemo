package springbootdemomqttclient.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springbootdemomqttclient.demo.service.sub.MqttSub;

import javax.annotation.PostConstruct;

/**
 * @author zhangdi03
 */
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    private MqttSub mqttSub;

    public DemoApplication(MqttSub mqttSub) {
        this.mqttSub = mqttSub;
    }

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，
     * 并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行。
     */
    @PostConstruct
    public void consumeMqttClient() {
        mqttSub.init();
    }
}
