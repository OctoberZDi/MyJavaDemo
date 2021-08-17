package jackson.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Student
 * @Description: 学生类
 * @Author: zhangdi
 * @Date: 2020年11月19日 16:51
 **/
public class Student {
    public Student(String name, String nickName, Integer age, Info info) {
        this.name = name;
        this.nickName = nickName;
        this.age = age;
        this.info = info;
    }

    public Student(String name, String nickName, Integer age) {
        this.name = name;
        this.nickName = nickName;
        this.age = age;
    }

    public Student() {
    }

    public Student(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Student student = objectMapper.readValue(json, Student.class);
            this.name = student.getName();
            this.nickName = student.getNickName();
            this.age = student.getAge();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", info=" + info +
                '}';
    }

    private String name;
    @JsonProperty(value = "nick")
    private String nickName;
    private Integer age;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Info info;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

