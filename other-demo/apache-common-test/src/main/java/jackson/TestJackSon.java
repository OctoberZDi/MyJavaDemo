package jackson;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.entity.Student;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestJackSon
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年11月19日 16:51
 **/
public class TestJackSon {
    public static void main(String[] args) {
        Student student = new Student("张迪", "小迪", 30);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String studentStr = objectMapper.writeValueAsString(student);

            System.out.println("将对象序列化到json文件中。。。");
            objectMapper.writeValue(new File("test111.json"), studentStr);

            System.out.println("将json文件中的内容反序列化到对象中。。。");
            Student student1 = objectMapper.readValue(new File("test111.json"), Student.class);
            System.out.println(student1);
            System.out.println("JsonGenerator======= 写入JSON字符串");
            JsonFactory jsonFactory = new JsonFactory();
            JsonGenerator generator = jsonFactory.createGenerator(new File("test111.json"), JsonEncoding.UTF8);
            generator.writeStartObject();
            generator.writeStringField("name", "张迪222");
            generator.writeStringField("nickName", "nickname2222");
            generator.writeStringField("age", "2222");
            generator.writeEndObject();
            generator.close();

            Student student2 = objectMapper.readValue(new File("test111.json"), Student.class);
            System.out.println(student2);

            System.out.println("JsonGenerator======= 读取JSON");
            JsonParser parser = jsonFactory.createParser(new File("test111.json"));
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                System.out.println(MessageFormat.format("token={0},value={1}", parser.getCurrentToken(), parser.getText()));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
