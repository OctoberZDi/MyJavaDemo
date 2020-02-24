package com.zd.demo.beetl.loader;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TemplateLoader
 * @Description: 模板夹杂器
 * @Author: zhangdi
 * @Date: 2020年02月15日 15:54
 **/
public class TemplateLoader {

    private static final GroupTemplate groupTemplate;

    static {
        ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader("templates");
        Configuration configuration = null;
        try {
            configuration = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        groupTemplate = new GroupTemplate(classpathResourceLoader, configuration);
    }

    public void generate() throws IOException {
        Template template = groupTemplate.getTemplate("test.java.btl");
        template.binding("projectName", "MyProjcetName");
        String className = "MyClassName";
        template.binding("className", className);
        template.binding("description", "MyDescription");
        template.binding("author", "description");
        template.binding("arg", "hello beetl");
        template.binding("date", LocalDate.now());

        String path = System.getProperty("user.dir") + File.separator + "other-demo\\beetl\\src\\main\\java\\com\\zd\\demo\\beetl\\generate" + File.separator + className + "Main.java ";
        System.out.println(path + "***");
        File file = new File(path);
        File parentFile = file.getParentFile();
        System.out.println(parentFile);
        if (!file.exists()) {
            parentFile.mkdirs();
            System.out.println("file is not exists,,,");
            file.createNewFile();
        }
        template.renderTo(new FileOutputStream(file));
    }
}
