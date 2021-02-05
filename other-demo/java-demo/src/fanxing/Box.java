package fanxing;

import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Box
 * @Description: 定义一个泛型类box
 * @Author: zhangdi
 * @Date: 2020年05月26日 10:38
 **/
public class Box<A> {

    private A object;

    public A getObject() {
        return object;
    }

    public void setObject(A object) {
        this.object = object;
    }

    //将T换成了A，在执行效果上是没有任何区别的，只不过我们约定好了T代表type，所以还是按照约定规范来比较好，增加了代码的可读性。
    public static void main(String[] args) {
        //创建一个Box对象，不带泛型参数，发现获取对象的时候需要强制转换
        //创建一个Box对象，带泛型参数，获取对象的时候就不需要强制转换
        Box<Fruit> box2 = new Box<Fruit>();
        box2.setObject(new Fruit("苹果", 5.6f));
        Fruit apple = box2.getObject();

        System.out.println(box2.getObject().getName() + " " + box2.getObject().getPrice() + "/斤");
    }
}


