package demo;

import data.Employee;
import service.IEmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.FileHandler;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: demo.EmployeeTest
 * @Description: demo
 * @Author: zhangdi
 * @Date: 2020年05月25日 15:59
 **/
public class EmployeeTest {
    private static List<Employee> list;

    static {
        System.out.println("static 块");
        list = Arrays.asList(new Employee(111, "张迪", 18, 9999), new Employee(222, "张筱满", 2,
                        100000)
                , new Employee(333, "朱玉", 16, 8888));
    }

    private static List<Employee> filterEmployeeAge2(List<Employee> employees) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        List<Employee> list = new ArrayList<>();
        for (Employee emp : employees) {
            list.add(emp);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("main  方法");
       /* List<Employee> employees = filterEmployeeAge2(list);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("**********");
        System.out.println("lambda 方式");*/


        System.out.println("无参");
        list.forEach(e -> System.out.println(e));
        System.out.println("lambda 语句");
        List<Employee> list2 = new ArrayList<>();
        list.forEach(e -> {
            if (e.getAge() > 15) {
                list2.add(e);
                System.out.println(e);
            }
        });

        // 定义lambda表达式
        System.out.println("定义lambda表达式");
        IEmployeeService service1 = e -> {
            List<Employee> result = new ArrayList<>();
            for (Employee employee : e) {
                if (e.contains("张")) {
                    result.add(employee);
                }
            }
            return result;
        };

        List<Employee> b = service1.getList(list);
        System.out.println(b);
        System.out.println("list 的 employee");
        list.forEach(employee -> employee.getName().contains("张迪"));
    }
}
