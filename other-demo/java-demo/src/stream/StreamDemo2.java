package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: StreamDemo2
 * @Description: StreamDemo2
 * @Author: zhangdi
 * @Date: 2021年02月01日 14:12
 **/
public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        Stream<String> stream = strings.stream();
    }
}
