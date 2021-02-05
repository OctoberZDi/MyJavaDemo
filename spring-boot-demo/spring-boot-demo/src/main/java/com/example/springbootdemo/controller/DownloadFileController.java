package com.example.springbootdemo.controller;

import com.example.springbootdemo.configuration.MyConstant;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Objects;

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

    @RequestMapping(value = "download1", method = RequestMethod.GET)
    public void copy() throws IOException {
        InputStream resourceAsStream = Objects.requireNonNull(resourceLoader.getClassLoader()).getResourceAsStream(
                "test/index.html");
        System.out.println("111");
        File file = new File("D:\\test\\index1.html");
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(resourceAsStream, fileOutputStream);
        IOUtils.closeQuietly(resourceAsStream);
        IOUtils.closeQuietly(fileOutputStream);
    }

    @RequestMapping(value = "download2", method = RequestMethod.GET)
    public void copy2() throws IOException {
        InputStream inputStream = resourceLoader.getResource(ResourceUtils.CLASSPATH_URL_PREFIX +
                "test/index.html").getInputStream();
        System.out.println("222");
        File file = new File("D:\\test\\index2.html");
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(inputStream, fileOutputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(fileOutputStream);
    }

    @RequestMapping(value = "download3", method = RequestMethod.GET)
    public void copy3() throws IOException {
        InputStream resourceAsStream = Objects.requireNonNull(ClassUtils.getDefaultClassLoader())
                .getResourceAsStream("test/index.html");
        System.out.println("333");
        File file = new File("D:\\test\\index3.html");
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(resourceAsStream, fileOutputStream);
        IOUtils.closeQuietly(resourceAsStream);
        IOUtils.closeQuietly(fileOutputStream);
    }

    @RequestMapping(value = "download4", method = RequestMethod.GET)
    public void copy4() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream
                ("test/index.html");
        System.out.println("444");
        File file = new File("D:\\test\\index4.html");
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(inputStream, fileOutputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(fileOutputStream);
    }

    @RequestMapping(value = "download5", method = RequestMethod.GET)
    public void copy5() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/test/index.html");
        System.out.println("555");
        File file = new File("D:\\test\\index5.html");
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(inputStream, fileOutputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(fileOutputStream);
    }

    @RequestMapping(value = "download6", method = RequestMethod.GET)
    public void copy6() throws IOException {
        InputStream inputStream = new ClassPathResource("/test/index.html").getInputStream();
        System.out.println("666");
        File file = new File("D:\\test\\index6.html");
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(inputStream, fileOutputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(fileOutputStream);
    }


    @RequestMapping(value = "download")
    public void copyFiles2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 方式1 ok
        InputStream resourceAsStream = Objects.requireNonNull(resourceLoader.getClassLoader()).getResourceAsStream(
                "test/springboot-demo.zip");
        // 方式2 ok 推荐
        // InputStream inputStream = resourceLoader.getResource(ResourceUtils.CLASSPATH_URL_PREFIX +
        // "test/springboot-demo.zip").getInputStream();

        // 方式3 ok
        // InputStream resourceAsStream = Objects.requireNonNull(ClassUtils.getDefaultClassLoader())
        // .getResourceAsStream("test/springboot-demo.zip");

        // 方式4 ok
        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream
        // ("test/springboot-demo.zip");

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
