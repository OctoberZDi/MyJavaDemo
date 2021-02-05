package com.example.springbootdemofileuploadserver.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FileUploadController
 * @Description: FileUploadController
 * @Author: zhangdi
 * @Date: 2021年01月26日 15:31
 **/
@RestController
@RequestMapping(value = "service")
public class FileUploadController {

    @PostMapping(value = "uploadFile")
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        return "我来自服务端：" + file.getOriginalFilename() + new Random().nextInt(10);
    }

    @GetMapping(value = "hello")
    public String hello() {
        return "hello，i am form service...";
    }
}
