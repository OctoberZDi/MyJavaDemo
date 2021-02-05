package com.example.springbootdemofileuploadclient.service;

import com.example.springbootdemofileuploadclient.config.MultipartSupportConfig;
import com.example.springbootdemofileuploadclient.service.impl.FileUploadFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FileUploadService
 * @Description: service.FileUploadService
 * @Author: zhangdi
 * @Date: 2021年01月26日 17:46
 **/
@FeignClient(value = "fileupload-service", configuration = MultipartSupportConfig.class, fallbackFactory = FileUploadFallback.class)
public interface IFileUploadService {

    @PostMapping(value = "/fileupload/service/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);

    @GetMapping(value = "/fileupload/service/hello")
    String handleHello();
}
