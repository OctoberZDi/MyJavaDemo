package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ConsumerTest
 * @Description: ddd
 * @Author: zhangdi
 * @Date: 2020年09月03日 09:30
 **/
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = ConsumerTest.testConsumer();
        // consumer.accept("world");

        System.out.println("===============");
        testConsumer2();
        System.out.println("===============");
        testBiPredicate();
        System.out.println("===============");

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("获取所有大于3的数");
        test(arr, x -> x > 3);
        System.out.println("获取所有偶数");
        test(arr, x -> x % 2 == 0);
        System.out.println("获取所有奇数");
        test(arr, x -> x % 2 == 1);
    }

    private static Consumer<String> testConsumer() {
        Consumer<String> consumer = x -> System.out.println("hello " + x);
        return consumer;
    }

    private static void testConsumer2() {
        Consumer<Integer> consumer1 = x -> System.out.println("hello " + x);
        Consumer<Integer> consumer2 = x -> System.out.println(x * x);
        consumer2.andThen(consumer1).andThen(consumer2).accept(22);
    }

    private static void testBiPredicate() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        System.out.println(biPredicate.test("22", "22"));
    }

    private static void test(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(x -> {
            if (predicate.test(x)) {
                System.out.println(x + " ");
            }
        });
    }
}
