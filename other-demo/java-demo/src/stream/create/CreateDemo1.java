package stream.create;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: CreateDemo1
 * @Description: stream的创建
 * @Author: zhangdi
 * @Date: 2021年04月23日 09:38
 **/
public class CreateDemo1 {
    public static void main(String[] args) {
        // 通过集合数组创建
        // 1、java.util.Collection.stream() 创建
        List<String> strings = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream = strings.stream();
        // 创建一个并行流
        Stream<String> stringStream = strings.parallelStream();
        // 2、java.util.Arrays.stream(T[] array)方法创建
        int[] arr1 = {1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(arr1);
        // 3、使用stream的静态方法创建
        // of
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        // iterate()
        Stream<Integer> limit = Stream.iterate(0, (x) -> x + 3).limit(4);
        limit.forEach(System.out::println);

        // generate()
        Stream<Double> limit1 = Stream.generate(Math::random).limit(4);
        limit1.forEach(System.out::println);
    }
}
