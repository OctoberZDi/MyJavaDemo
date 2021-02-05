package gc;

import java.io.ByteArrayOutputStream;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestGC
 * @Description: 如果对象不再使用，不置为null会有什么后果
 * @Author: zhangdi
 * @Date: 2020年05月28日 10:09
 **/
public class TestGC {
    public static void main(String[] args) {
        if (true) {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length / 64);
        }

        System.gc();
    }
}
