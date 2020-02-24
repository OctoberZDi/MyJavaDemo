package com.zd.demo.hutooldemo.excel;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: codes-generator
 * @ClassName: ExcelData
 * @Description: ExcelData
 * @Author: zhangdi
 * @Date: 2020年02月20日 10:33
 **/
@Data
public class ExcelData {
    private String fileName;
    private List<String> head;
    private List<List<String>> data;
}
