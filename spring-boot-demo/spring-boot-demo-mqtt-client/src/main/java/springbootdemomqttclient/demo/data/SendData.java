package springbootdemomqttclient.demo.data;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: SendData
 * @Description: SendData
 * @Author: zhangdi
 * @Date: 2021年03月08日 15:33
 **/
public class SendData {
    private String topic;
    private String key;
    private String value;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
