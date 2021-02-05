package fanxing;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Apple
 * @Description: 测试apple
 * @Author: zhangdi
 * @Date: 2020年05月26日 10:39
 **/
public class Fruit {

    private String name;
    private float price;

    public Fruit(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
