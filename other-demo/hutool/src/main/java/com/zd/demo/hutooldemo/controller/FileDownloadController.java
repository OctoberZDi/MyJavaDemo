package com.zd.demo.hutooldemo.controller;

import com.zd.demo.hutooldemo.util.ZipUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FileDownloadController
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年02月21日 11:37
 **/
@RestController
@RequestMapping(value = "file")
public class FileDownloadController {

    @Autowired
    ResourceLoader resourceLoader;

    @RequestMapping(value = "download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 方式1 ok
        //InputStream resourceAsStream = Objects.requireNonNull(resourceLoader.getClassLoader()).getResourceAsStream("test/springboot-demo.zip");
        // 方式2 ok 推荐
        // InputStream inputStream = resourceLoader.getResource(ResourceUtils.CLASSPATH_URL_PREFIX + "test/springboot-demo.zip").getInputStream();

        // 方式3 ok
        // InputStream resourceAsStream = Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResourceAsStream("test/springboot-demo.zip");

        // 方式4 ok
        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test/springboot-demo.zip");

        // 测试文件夹


        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test");

        // 方式5 ok
        // InputStream inputStream = this.getClass().getResourceAsStream("/test/springboot-demo.zip");

        // 方式6 ok
//        InputStream inputStream = new ClassPathResource("/test/springboot-demo.zip").getInputStream();

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
        assert inputStream != null;
        IOUtils.copy(inputStream, outputStream);
        response.flushBuffer();
    }

    @RequestMapping(value = "downloadZip/{path}")
    public String downloadZip(@PathVariable String path) throws IOException {
        ZipUtil.zipFile(path, path + File.separator + "downloaded");
        return "";
    }
}
