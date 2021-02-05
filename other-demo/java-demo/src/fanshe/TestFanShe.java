package fanshe;

import data.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestFanShe
 * @Description: 测试反射
 * @Author: zhangdi
 * @Date: 2020年11月23日 10:56
 **/
public class TestFanShe {
    public static void main(String[] args) {
        Employee employee1 = Employee.EmployeeBuilder.anEmployee().withAge(12).withId(11).withName("zhangdi").withSalary(333).build();
        System.out.println(employee1);

        Class<Employee> employeeClass = Employee.class;
        try {
            Employee employee = employeeClass.newInstance();
            employee.setId(0L);
            employee.setName("张迪");
            employee.setAge(0);
            employee.setSalary(200);
            System.out.println(employee);

            System.out.println("=====获取对象的包名以及类名");
            System.out.println(" class:" + employeeClass.getName());
            System.out.println(" simpleName:" + employeeClass.getSimpleName());
            System.out.println(" name:" + employee.getClass().getName());
            System.out.println(" packageName:" + employee.getClass().getPackage().getName());
            Constructor<?>[] constructors = employeeClass.getConstructors();
            System.out.println("=====获取类的构造函数信息");
            Arrays.stream(constructors).forEach(item -> {
                System.out.println("@name: " + item.getName());
                System.out.println(" modifier: " + item.getModifiers());
                System.out.println(" parameterCount: " + item.getParameterCount());
                System.out.println(" 构造参数类型如下：");
            });
            System.out.println("=====获取class对象");
            System.out.println(" 方式1 Class.forName(data.Employee)");
            Class<?> invocation1 = Class.forName("data.Employee");
            System.out.println(invocation1);
            System.out.println(" 方式2 employee.getClass()");
            Class<? extends Employee> invocation2 = employee.getClass();
            System.out.println(invocation2);
            System.out.println(" 方式3 Employee.class");
            Class<Employee> employeeClass1 = Employee.class;
            System.out.println(employeeClass1);

            System.out.println("=====getInstance()获取指定类型的实例化对象");
            Class<?> aClass = Class.forName("data.Employee");
            Employee employee2 = (Employee) aClass.newInstance();
            employee2.setId(0L);
            employee2.setName("new instance");
            employee2.setAge(0);
            employee2.setSalary(0L);
            System.out.println(employee2);

            System.out.println("=====通过构造函数对象实例化对象");
            Constructor<?>[] constructors1 = aClass.getConstructors();
            Arrays.stream(constructors1).forEach(System.out::println);

            System.out.println("=====获取类继承的接口");
            Class<?>[] interfaces = aClass.getInterfaces();
            Arrays.stream(interfaces).forEach(System.out::println);
            System.out.println("=====获取类继承的类");
            Class<?> superclass = aClass.getSuperclass();
            System.out.println(superclass);
            Method[] methods = superclass.getMethods();
            for (Method method : methods) {
                if ("run".equals(method.getName())) {
                    method.invoke(superclass.newInstance(), "cat");
                }
                if ("run2".equals(method.getName())) {
                    System.out.println("无法获取私有方法");
                    method.invoke(superclass.newInstance(), "elephant");
                }
            }
            System.out.println("=====获取当前类的公有属性和私有属性以及更新");
            Field[] fields = aClass.getFields();
            System.out.println("使用getFields()可以获取到public的属性，包括static属性，");
            Arrays.stream(fields).forEach(item -> System.out.println(" " + item));
            System.out.println("使用getDeclaredFields()可以获取所有声明的属性，不管是public，protected,private不同修饰的属性。");
            Field[] declaredFields = aClass.getDeclaredFields();
            Arrays.stream(declaredFields).forEach(item -> System.out.println(" " + item));
            System.out.println("使用field.set(object,value)修改属性，但是private 不能直接set否则会报错。解决方案：field.setAccessible(true);，相当于打开了操作的权限。");

            Class<?> aClass1 = Class.forName("data.Employee");
            Employee employee3 = (Employee) aClass1.newInstance();
            employee3.setName("111");
            System.out.println(" 修改前" + employee3);
            System.out.println(employee3);
            Field name = aClass1.getDeclaredField("name");
            name.set(employee3, "修改");
            System.out.println(" 修改后" + employee3);
            System.out.println("=====获取以及调用类的公有/私有方法");
            System.out.println(" getMethods获取所有方法，也包含父类方法");
            Arrays.stream(aClass.getMethods()).forEach(item -> System.out.println("  " + item));
            System.out.println("getDeclaredMethods确实可以获取到公有和私有的方法，不管是静态还是非静态，但是它是获取不到父类的方法的。");
            Arrays.stream(aClass.getDeclaredMethods()).forEach(item -> System.out.println("  " + item));
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}