package Collections;

import common.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestCollections
 * @Description: testCollections
 * @Author: zhangdi
 * @Date: 2020年11月17日 16:21
 **/
public class TestCollections {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("张迪1", 29, "山东省临沂市1"));
        users.add(new User("张迪2", 29, "山东省临沂市2"));
        users.add(new User("张迪3", 29, "山东省临沂市3"));
        users.add(new User("张迪4", 29, "山东省临沂市4"));
        System.out.println("CollectionUtils.isNotEmpty(users):" + CollectionUtils.isNotEmpty(users));
        System.out.println("CollectionUtils.isEmpty(users):" + CollectionUtils.isEmpty(users));
        List<User> users2 = new ArrayList<User>();
        users2.add(new User("科比1", 29, "美国洛杉矶"));
        users2.add(new User("科比2", 29, "美国芝加哥"));
        System.out.println("addAll 前：" + users);
        CollectionUtils.addAll(users, users2.toArray());
        System.out.println("addAll 后：" + users);

        // MapUtils
        System.err.println("===================MapUtils的使用  From===================");
        Map<String, String> testMap = new HashMap<String, String>(12);
        testMap.put("A", "aaa");
        testMap.put("B", "bbb");
        testMap.put("C", "ccc");
        testMap.put("D", "ddd");
        String a = MapUtils.getString(testMap, "A");
        System.out.println("***" + a);
        System.err.println("===================MapUtils的使用  End===================");
        
    }
}
