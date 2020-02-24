package com.zd.demo.hutooldemo.excel;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ExcelReaderMain
 * @Description: 测试ExcelReader
 * @Author: zhangdi
 * @Date: 2020年02月19日 09:01
 **/
public class ExcelReaderMain {
    public static void main(String[] args) {
        String filePath = "\"D:\\\\testCode\\\\test.xlsx\"";
        //从文件中读取Excel为ExcelReader
        ExcelReader excelReader = ExcelUtil.getReader(new File(filePath));

        //流中读取Excel为ExcelReader（比如从ClassPath中读取Excel文件）
        ExcelReader excelReader2 = ExcelUtil.getReader(ResourceUtil.getStream(filePath));
    }
}
