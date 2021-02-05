package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestArrayToList
 * @Description: 数组转list
 * @Author: zhangdi
 * @Date: 2020年10月14日 09:18
 **/
public class TestArrayToList {
    public static void main(String[] args) {
        String[] testArr = new String[]{"aaa", "bbb", "ccc"};
        // 第一种方式：Arrays.asList
        List<String> strings = Arrays.asList(testArr);
        System.out.println(strings);

        // 第二种方式：new ArrayList<String>(Arrays.asList
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(testArr));
        System.out.println(list);

        // 第三种方式：通过集合工具类Collections.addAll 最高效
        boolean b = Collections.addAll(strings);
        System.out.println(b);
    }
}
