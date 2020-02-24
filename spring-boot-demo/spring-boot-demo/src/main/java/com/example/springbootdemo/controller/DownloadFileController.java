package com.example.springbootdemo.controller;

import com.example.springbootdemo.configuration.MyConstant;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @ProjectName: springboot-demo
 * @ClassName: TestController
 * @Description: ddd
 * @Author: zhangdi
 * @Date: 2020年02月20日 17:34
 **/
@RestController
@RequestMapping(value = "test")
public class DownloadFileController {
    @Autowired
    MyConstant myConstant;

    @RequestMapping(value = "test")
    public void testConstant() {
        System.out.println(myConstant.defaultPageConfig("2").get("type"));
    }

    @Autowired
    ResourceLoader resourceLoader;

    @RequestMapping(value = "download")
    public void copyFiles2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 方式1 ok
        //InputStream resourceAsStream = Objects.requireNonNull(resourceLoader.getClassLoader()).getResourceAsStream("test/springboot-demo.zip");
        // 方式2 ok 推荐
        // InputStream inputStream = resourceLoader.getResource(ResourceUtils.CLASSPATH_URL_PREFIX + "test/springboot-demo.zip").getInputStream();

        // 方式3 ok
        // InputStream resourceAsStream = Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResourceAsStream("test/springboot-demo.zip");

        // 方式4 ok
        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test/springboot-demo.zip");

        // 方式5 ok
        // InputStream inputStream = this.getClass().getResourceAsStream("/test/springboot-demo.zip");

        // 方式6 ok
        InputStream inputStream = new ClassPathResource("/test/springboot-demo.zip").getInputStream();

        // 方式7 开发环境OK，生产环境NG
        // File file = ResourceUtils.getFile("classpath:excleTemplate/test.xlsx");
        //InputStream inputStream = new FileInputStream(file);

        ServletOutputStream outputStream = response.getOutputStream();
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Content-Disposition",
                "attachment; filename=" + URLEncoder.encode("springboot-demo.zip", "UTF-8"));
        // 自动判断下载文件类型(zip)
        response.setContentType("multipart/form-data");
        IOUtils.copy(inputStream, outputStream);

        response.flushBuffer();
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }

}
