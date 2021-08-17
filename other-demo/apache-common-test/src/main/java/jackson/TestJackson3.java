package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.entity.Info;
import jackson.entity.Student;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestJackson3
 * @Description: test
 * @Author: zhangdi
 * @Date: 2021年07月05日 11:17
 **/
public class TestJackson3 {
    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student("张迪", "小迪", 30, new Info() {{
            this.setScore(200);
            this.setComment("你好");
        }});
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);

        String s1 = "{\"name\":\"张迪\",\"age\":30,\"info\":{},\"nick\":\"小迪\"}";
        Student student1 = objectMapper.readValue(s1, Student.class);
        System.out.println("test");
        System.out.println(student1);
    }
}
