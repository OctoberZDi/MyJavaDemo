package com.example.springbootdemofileuploadclient.controller;

import com.example.springbootdemofileuploadclient.service.IBpmImporterService;
import com.example.springbootdemofileuploadclient.service.IFileUploadService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FileUploadController
 * @Description: fileuploadController
 * @Author: zhangdi
 * @Date: 2021年01月26日 18:00
 **/
@RestController
@RequestMapping(value = "client")
public class FileUploadController {

    @Value("${test.file1}")
    String file1;

    @Value("${test.file2}")
    String file2;

    @Autowired
    IFileUploadService fileUploadService;

    @Autowired
    IBpmImporterService bpmImporterService;

    @PostMapping(value = "uploadFile")
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        return fileUploadService.handleFileUpload(file);
    }

    @GetMapping(value = "hello")
    public String hello() {
        return "this is client=======" + fileUploadService.handleHello();
    }

    @GetMapping(value = "hello1")
    public String hello1(@RequestParam(value = "name",required = false) String name) {
        return StringUtils.isBlank(name) ? "hello,this is ok!!!" : "hello,this is " + name;
    }

    @PostMapping(value = "uploadFile2")
    public String handleFileUpload2() {
        System.out.println(file1);
        File file = new File(file1);
        FileItem fileItem = new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, file.getName());
        try (FileInputStream fileInputStream = new FileInputStream(file); OutputStream outputStream = fileItem.getOutputStream()) {
            IOUtils.copy(fileInputStream, outputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        String stringObjectMap = null;

        try {
            stringObjectMap = fileUploadService.handleFileUpload(multipartFile);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return stringObjectMap;
    }

    @PostMapping(value = "uploadFileBpm")
    public String handleFileUploadForBpm() {
        System.out.println("uploadFileBpm:  " + file2);
        File file = new File(file2);
        FileItem fileItem = new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, file.getName());
        try (FileInputStream fileInputStream = new FileInputStream(file); OutputStream outputStream = fileItem.getOutputStream()) {
            IOUtils.copy(fileInputStream, outputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        String stringObjectMap = null;

        try {
            stringObjectMap = bpmImporterService.testUpload(multipartFile);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return stringObjectMap;
    }

    @PostMapping(value = "importForModelDesigner")
    public Map<String, Object> handleFileUploadForBpm2() {
        System.out.println("importForModelDesigner:  " + file2);
        File file = new File(file2);
        FileItem fileItem = new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, file.getName());
        try (FileInputStream fileInputStream = new FileInputStream(file); OutputStream outputStream = fileItem.getOutputStream()) {
            IOUtils.copy(fileInputStream, outputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        Map<String, Object> stringObjectMap = null;

        try {
            stringObjectMap = bpmImporterService.importModel(multipartFile);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return stringObjectMap;
    }

}
