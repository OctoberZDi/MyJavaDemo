package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: StreamDemo
 * @Description: java 中双冒号的使用方法
 * @Author: zhangdi
 * @Date: 2020年07月06日 17:09
 **/
public class DoubleColonDemo {
    public static void printValue(String str) {
        System.out.println("print value : " + str);
    }

    public static void main(String[] args) {

        List<String> al = Arrays.asList("a", "b", "c", "d");
        //
        System.out.println("使用for调用printValue");
        for (String a : al) {
            DoubleColonDemo.printValue(a);
        }

        System.out.println("使用forEach调用printValue");

        al.forEach(x -> {
            DoubleColonDemo.printValue(x);
        });

        System.out.println("使用Stream调用printValue");
        Consumer<String> methodParam = DoubleColonDemo::printValue;
        al.forEach(methodParam);
    }
}
