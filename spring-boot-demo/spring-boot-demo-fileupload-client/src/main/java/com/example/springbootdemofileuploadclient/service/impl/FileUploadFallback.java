package com.example.springbootdemofileuploadclient.service.impl;

import com.example.springbootdemofileuploadclient.service.IFileUploadService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IFileUploadFallback
 * @Description: ff
 * @Author: zhangdi
 * @Date: 2021年01月27日 15:23
 **/
@Component
public class FileUploadFallback implements FallbackFactory<IFileUploadService> {
    @Override
    public IFileUploadService create(Throwable throwable) {
        return new IFileUploadService() {
            @Override
            public String handleFileUpload(MultipartFile file) {
                System.out.println("=============handleFileUpload 失败");
                System.out.println(throwable.getMessage());
                return null;
            }

            @Override
            public String handleHello() {
                System.out.println("=============handleHello失败");
                System.out.println(throwable.getMessage());
                return null;
            }
        };
    }
}
