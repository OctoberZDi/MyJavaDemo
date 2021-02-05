package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestHashMap
 * @Description: 测试hashmap遍历
 * @Author: zhangdi
 * @Date: 2020年11月23日 09:17
 **/
public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>() {{
            this.put(1, "Java");
            this.put(2, "C++");
            this.put(3, "C#");
            this.put(4, "Python");
            this.put(5, "Html");
        }};

        System.out.println("1、使用迭代器EntrySet遍历，IDE不推荐");
        Iterator<Map.Entry<Integer, String>> entrySetIterator = map.entrySet().iterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry<Integer, String> next = entrySetIterator.next();
            System.out.println("   key=" + next.getKey() + ",value=" + next.getValue());
        }

        System.out.println("2、使用迭代器KeySet遍历，IDE不推荐");
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("   key=" + next + ",value=" + map.get(next));
        }

        System.out.println("3、使用ForEach EntrySet");
        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            System.out.println("   key=" + integerStringEntry.getKey() + ",value=" + integerStringEntry.getValue());
        }

        System.out.println("4、使用ForEach keySet");
        for (Integer integer : map.keySet()) {
            System.out.println("   key=" + integer + ",value=" + map.get(integer));
        }
        System.out.println("5、Lambda forEach");
        map.forEach((key, value) -> System.out.println("   key=" + key + ",value=" + value));
        System.out.println("6、Streams API 单线程,IDE不推荐");
        // The 'stream().forEach()' chain can be replaced with 'forEach()' (may change semantics)
        map.entrySet().stream().forEach((entry) -> {
            System.out.println("   key=" + entry.getKey() + ",value=" + entry.getValue());
        });

        // 根据 map 中的 key 去判断删除
        map.keySet().removeIf(key -> key == 1);
        map.forEach((key, value) -> System.out.println("   show:" + key));
        System.out.println("7、Streams API 多线程");
        map.entrySet().parallelStream().forEach((entry) -> System.out.println("   key=" + entry.getKey() + ",value=" + entry.getValue()));

        // stream 删除
        System.out.println("stream 删除");
        Map<Integer, String> collect = map.entrySet().stream().filter((entry) -> 2 != entry.getKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("stream 过滤后的结果 from");
        collect.entrySet().parallelStream().forEach((entry) -> System.out.println("   key=" + entry.getKey() + ",value=" + entry.getValue()));
        System.out.println("原map");
        map.entrySet().parallelStream().forEach((entry) -> System.out.println("   key=" + entry.getKey() + ",value=" + entry.getValue()));
        System.out.println("stream 过滤后的结果 end");

        map.entrySet().stream().filter((entry) -> 2 != entry.getKey()).forEach((entry) -> {
            if (entry.getKey() == 1) {
                System.out.println("   已删除" + entry.getKey());
            } else {
                System.out.println("   未删除" + entry.getKey());
            }
        });
    }
}