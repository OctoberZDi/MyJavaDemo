package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.entity.Student;

import java.io.File;
import java.io.IOException;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestJackSon2
 * @Description: ddd
 * @Author: zhangdi
 * @Date: 2020年11月21日 17:19
 **/
public class TestJackSon2 {
    public static void main(String[] args) {
        Student student = new Student("张迪", "小迪", 30);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 写为字符串
            System.out.println("========== 写 ==========");
            System.out.println("========== 写为字符串 ==========");
            String s = objectMapper.writeValueAsString(student);
            System.out.println(s);
            System.out.println("========== 写为文件 ==========");
            File file = new File("student.json");
            objectMapper.writeValue(file, student);
            System.out.println(file.getAbsolutePath());
            System.out.println("========== 写为字节流 ==========");
            byte[] bytes = objectMapper.writeValueAsBytes(student);
            System.out.println(new String(bytes));

            System.out.println("======== 读 ===========");
            System.out.println("======== 从字符串读取 ===========");
            Student student1 = objectMapper.readValue(s, Student.class);
            System.out.println(student1);
            System.out.println("======== 从文件读取 ===========");
            Student student2 = objectMapper.readValue(file, Student.class);
            System.out.println(student2);

            System.out.println("======== 从字节流读取 ===========");
            Student student3 = objectMapper.readValue(bytes, Student.class);
            System.out.println(student3);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}