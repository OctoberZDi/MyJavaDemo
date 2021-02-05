package java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Base64Test
 * @Description: base64
 * @Author: zhangdi
 * @Date: 2020年09月03日 09:58
 **/
public class Base64Test {
    public static void main(String[] args) {
        System.out.println("编码");
        Base64.Encoder encoder = Base64.getEncoder();
        String sEncoder = encoder.encodeToString("hello world".getBytes(StandardCharsets.UTF_8));
        System.out.println(sEncoder);

        System.out.println("解码");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(sEncoder);
        System.out.println(new String(decode));
    }
}
