package file;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @ProjectName: codes-parent
 * @ClassName: FileUtilTestMain
 * @Description: 测试文件
 * @Author: zhangdi
 * @Date: 2020年06月26日 09:47
 **/
public class FileUtilTestMain {

    private static void listAllFiles(File dir) {
        //返回的是直接子目录（文件）的抽象
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //递归
                    listAllFiles(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            // 遍历目录
            String srcDir = "D:/cg/test";
            listAllFiles(new File(srcDir));

            String srcPath = "D:/cg/test";
            File file1 = new File(srcPath);
            if (file1.isDirectory()) {
                System.out.println("这是个目录！");
            }

            // 复制文件，多了一层
            FileUtils.copyDirectoryToDirectory(file1, new File("D:/cg2/test"));
            // 压缩：

            ZipUtil.zipFile("D:/cg2/test", "d:/cg2/test.zip");

            System.out.println("===================");
            /*Scanner sca = new Scanner(System.in);

            //写文件
            System.out.print("请输入文件名：");
            String name = sca.next();
            //文件名        相对路径（项目名根目录下）
            File file = new File(name + ".txt");
            //true表示追加，如果文件存在 向里面继续添加内容
            FileOutputStream fos = new FileOutputStream(file, true);
            System.out.println("请输入写入的内容:");
            //FileOutputStream 是基于字节流  把要写入的信息 保存到字节数组中
            String str = sca.next();
            byte[] bytes = str.getBytes();
            //将字节数组中全部内容写到文件中   从0—数组的长度
            fos.write(bytes, 0, bytes.length);
            fos.close();//关闭流
            System.out.println("文件写入成功！");

            //读文件
            FileInputStream fis = new FileInputStream(file);
            //1KB       每次最多读取的1KB  根据文件大小而定
            byte[] bt = new byte[1024];
            int temp = 0;
            //将数据保存到数组（缓冲区）中 并返回读取的字节数  -1表示读完了
            while ((temp = fis.read(bt)) != -1) {
                //输出数组中保存内容 按照每次读取的字节数
                System.out.println(new String(bt, 0, temp));
            }
            fis.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
