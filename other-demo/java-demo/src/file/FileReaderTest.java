package file;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FileReaderTest
 * @Description: FileReaderTest
 * @Author: zhangdi
 * @Date: 2021年01月28日 17:14
 **/
public class FileReaderTest {
    public static void main(String[] args) {
        Path path = Paths.get("testFileReader.txt");
        boolean b = false;
        try {
            b = Files.deleteIfExists(path);
            System.out.println("deleteIfExists:" + b);
            Files.write(path, "你好，捡田螺的男孩！".getBytes(StandardCharsets.UTF_8));
            System.out.println("系统默认编码：" + Charset.defaultCharset());

            char[] chars = new char[10];
            String content = "";
            try (FileReader fileReader = new FileReader("testFileReader.txt")) {
                int count;
                while ((count = fileReader.read(chars)) != -1) {
                    content += new String(chars);
                }
            }
            System.out.println(content);

            System.out.println("===============================");
            content = "";
            try (FileInputStream fileInputStream = new FileInputStream("testFileReader.txt")) {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,StandardCharsets.UTF_8);
                int count;
                while ((count = inputStreamReader.read(chars)) != -1) {
                    content += new String(chars);
                }
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
