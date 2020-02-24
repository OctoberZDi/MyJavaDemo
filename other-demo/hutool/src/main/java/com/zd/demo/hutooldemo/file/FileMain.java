package com.zd.demo.hutooldemo.file;

import cn.hutool.core.io.FileUtil;
import com.zd.demo.hutooldemo.data.User;
import org.springframework.util.Assert;

import java.io.File;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: File
 * @Description: file
 * @Author: zhangdi
 * @Date: 2020年02月20日 11:38
 **/
public class FileMain {

    public static void main(String[] args) {
        User user = null;
        Assert.notNull(user, "测试信息");
        assert user != null;
        System.out.println(user.getName());

        File oFile = new File("D:/testCode/demo");
        File[] files = oFile.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        FileUtil.copy(oFile, new File("D:/testCode/demo3"), true);
        FileUtil.copy(oFile, new File("D:/testCode/demo4"), false);

        System.out.println("*************");
        List<File> files1 = FileUtil.loopFiles("D:/testCode/demo");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
