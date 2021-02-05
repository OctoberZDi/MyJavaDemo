package java8;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LambdaTest
 * @Description: lambda测试
 * @Author: zhangdi
 * @Date: 2020年09月03日 10:52
 **/
public class LambdaTest {
    public static void main(String[] args) {

        Integer i1 = 100, i2 = 100;
        int i3 = 1000, i4 = 1000;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        // 类型声明
        MathOperation mathOperation = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation mathOperation1 = (a, b) -> a - b;
        // 大括号中返回
        MathOperation mathOperation2 = (a, b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation mathOperation3 = (int a, int b) -> a / b;

        int operation = mathOperation.operation(10, 11);
        System.out.println(operation);
        System.out.println("=========");
        int operation1 = mathOperation1.operation(2, 4);
        System.out.println(operation1);
        System.out.println("=========");
        int operation2 = mathOperation2.operation(5, 6);
        System.out.println(operation2);
        System.out.println("=========");
        int operation3 = mathOperation3.operation(6, 8);
        System.out.println(operation3);
        System.out.println("=========");
    }

    interface MathOperation {
        /**
         * @param a
         * @param b
         * @return
         */
        int operation(int a, int b);
    }

    interface GreetService {
        /**
         * @param sth
         * @return
         */
        int saySth(String sth);
    }
}
