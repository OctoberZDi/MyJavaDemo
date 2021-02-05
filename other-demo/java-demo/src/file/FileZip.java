package file;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UnZipUtil
 * @Description: 解压文件
 * @Author: zhangdi
 * @Date: 2020年06月26日 14:22
 **/
public class FileZip {
    /**
     * zip文件压缩
     *
     * @param inputFile  待压缩文件夹/文件名
     * @param outputFile 生成的压缩包名字
     */
    public static void zipCompress(String inputFile, String outputFile) throws Exception {
        //创建zip输出流
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outputFile));
        //创建缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(out);
        File input = new File(inputFile);
        compress(out, bos, input, null);
        bos.close();
        out.close();
    }

    /**
     * 压缩文件名，可以写为null保持默认 递归压缩
     *
     * @param out   压缩输出流
     * @param bos   缓冲区
     * @param input 待压缩文件夹/文件名
     * @param name  文件名
     * @throws IOException IO异常
     */
    public static void compress(ZipOutputStream out, BufferedOutputStream bos, File input, String name) throws IOException {
        if (name == null) {
            name = input.getName();
        }
        //如果路径为目录（文件夹）
        if (input.isDirectory()) {
            //取出文件夹中的文件（或子文件夹）
            File[] fileList = input.listFiles();
            //如果文件夹为空，则只需在目的地zip文件中写入一个目录进入
            assert fileList != null;
            if (fileList.length == 0) {
                out.putNextEntry(new ZipEntry(name + "/"));
            } else {
                //如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
                for (File file : fileList) {
                    compress(out, bos, file, name + "/" + file.getName());
                }
            }
        } else {
            //如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
            out.putNextEntry(new ZipEntry(name));
            FileInputStream fos = new FileInputStream(input);
            BufferedInputStream bis = new BufferedInputStream(fos);
            int len;
            //将源文件写入到zip文件中
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            bis.close();
            fos.close();
        }
    }

    /**
     * zip解压
     *
     * @param inputFile   待解压文件名
     * @param destDirPath 解压路径
     */

    public static void zipUncompress(String inputFile, String destDirPath) throws Exception {
        //获取当前压缩文件
        File srcFile = new File(inputFile);
        // 判断源文件是否存在
        if (!srcFile.exists()) {
            throw new Exception(srcFile.getPath() + "所指文件不存在");
        }
        //开始解压
        //构建解压输入流
        ZipInputStream zIn = new ZipInputStream(new FileInputStream(srcFile));
        ZipEntry entry;
        File file;
        while ((entry = zIn.getNextEntry()) != null) {
            if (!entry.isDirectory()) {
                file = new File(destDirPath, entry.getName());
                if (!file.exists()) {
                    //创建此文件的上级目录
                    new File(file.getParent()).mkdirs();
                }
                OutputStream out = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                int len;
                byte[] buf = new byte[1024];
                while ((len = zIn.read(buf)) != -1) {
                    bos.write(buf, 0, len);
                }
                // 关流顺序，先打开的后关闭
                bos.close();
                out.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("D:/cg/test/aa.txt");
            File destFile = null;
            if (file.exists() && file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                destFile = new File("D:/cg/test/test/aa1.txt");
                FileOutputStream fileOutputStream = new FileOutputStream(destFile);
                IOUtils.copy(fileInputStream, fileOutputStream);
                IOUtils.closeQuietly(fileInputStream);
                IOUtils.closeQuietly(fileOutputStream);
            }
            zipCompress("D:/cg/test", "D:/cg/test.zip");
            // 压缩完后删除
            if (destFile != null && destFile.exists()) {
                boolean delete = destFile.delete();
                System.out.println(delete ? "删除成功" : "删除失败");
            }
            zipUncompress("D:/cg/test.zip", "D:/cg/test2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
