package com.zd.demo.hutooldemo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ZIP工具类
 *
 * @author hanxl
 * @version 1.0
 * @since 2020-01-15
 */
@Slf4j
public class ZipUtil {

    private ZipUtil() {
    }

    /**
     * 创建ZIP文件
     *
     * @param sourcePath 文件或文件夹路径
     * @param zipPath    生成的zip文件存在路径（包括文件名）
     */
    public static void zipFile(String sourcePath, String zipPath) throws IOException {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipPath);
            zos = new ZipOutputStream(fos);
            zip(new File(sourcePath), "", zos);
        } catch (FileNotFoundException e) {
            log.error("创建ZIP文件失败", e);
            throw e;
        } finally {
            try {
                if (zos != null) {
                    zos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                log.error("创建ZIP文件失败", e);
                throw e;
            }
        }
    }

    private static void zip(File file, String parentPath, ZipOutputStream zos) throws IOException {
        if (file.exists()) {
            // 处理目录
            if (file.isDirectory()) {
                parentPath += file.getName() + File.separator;
                File[] files = file.listFiles();
                if (files.length != 0) {
                    for (File f : files) {
                        zip(f, parentPath, zos);
                    }
                } else {
                    // 空目录则创建当前目录
                    try {
                        zos.putNextEntry(new ZipEntry(parentPath));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte[] content = new byte[1024];
                    int len;
                    while ((len = fis.read(content)) != -1) {
                        zos.write(content, 0, len);
                        zos.flush();
                    }

                } catch (IOException e) {
                    log.error("创建ZIP文件失败", e);
                    throw e;
                } finally {
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                    } catch (IOException e) {
                        log.error("创建ZIP文件失败", e);
                        throw e;
                    }
                }
            }
        }
    }

//    public static void main(String[] args) {
    //ZipUtil.createZip("D:\\testCode\\src", "D:\\testCodeZip\\demo.zip");
//    }
}
