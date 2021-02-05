package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FileUploadController
 * @Description: 文件上传demo
 * @Author: zhangdi
 * @Date: 2020年07月06日 13:58
 **/
@RequestMapping(value = "file")
@RestController
public class UploadFileController {
    /**
     * @return
     */
    @RequestMapping(value = "upload")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件是空的，上传失败！";
            }
            //文件名称
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            // 文件后缀
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf('.'));

            // 设置文件存储的路径
            String destPath = "D:/cg/uploaded/";
            File destFile = new File(destPath + originalFilename);
            if (!destFile.exists()) {
                // 创建目录
                boolean bCreated = destFile.getParentFile().mkdirs();
                System.out.println(bCreated ? "创建成功！" : "创建失败！");
            }

            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();

            return "上传失败！" + e.getMessage();
        }

        return "上传成功！";
    }

    /**
     * @return
     */
    @RequestMapping(value = "uploads")
    public String uploadFiles(HttpServletRequest request) throws IOException {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        BufferedOutputStream outputStream;
        String destPath = "D:/cg/uploaded2/";
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                File file1 = new File(destPath + file.getOriginalFilename());
                if (!file1.exists()) {
                    // 创建目录
                    boolean bCreated = file1.getParentFile().mkdirs();
                    System.out.println(bCreated ? "创建成功！" + file1.getPath() : "创建失败！" + file1.getPath());
                }
                outputStream =
                        new BufferedOutputStream(new FileOutputStream(file1));

                outputStream.write(bytes);
                outputStream.close();
            } else {
                System.out.println("file is empty " + file);
            }
        }
        return "上传多文件成功！";
    }
}
