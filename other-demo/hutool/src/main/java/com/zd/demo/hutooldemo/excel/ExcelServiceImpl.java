package com.zd.demo.hutooldemo.excel;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: codes-generator
 * @ClassName: ExcelServiceImpl
 * @Description: excelservice的实现类
 * @Author: zhangdi
 * @Date: 2020年02月19日 14:28
 **/
@Service
public class ExcelServiceImpl implements IExcelService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    /**
     * 客户端下载xls格式的excel
     *
     * @param data
     */
    @Override
    public void exportXlsToClient(Iterable<?> data) throws IOException {
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data, true);
        //out为OutputStream，需要写出到的目标流

        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=test.xls");
        ServletOutputStream out = response.getOutputStream();

        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

    /**
     * 客户端下载xlsx格式的excel
     *
     * @param data
     */
    @Override
    public void exportXlsxToClient(Iterable<?> data) throws IOException {
        // true 生成xlsx
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //  为true写出两行，Map的keys做为一行，values做为第二行，否则只写出一行values
        writer.write(data, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=test.xlsx");
        ServletOutputStream out = response.getOutputStream();

        // 是否关闭输出流
        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);
    }

    /**
     * 导出excel到指定路径
     *
     * @param data
     * @return 导出成功true；导出失败：false;
     */
    @Override
    public boolean exportToPath(Iterable<?> data, String destFilePath) {
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(destFilePath);
        //通过构造方法创建writer
        //ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");

        //跳过当前行，既第一行，非必须，在此演示用
        // writer.passCurrentRow();
        //一次性写出内容，强制输出标题
        writer.write(data, true);
        //关闭writer，释放内存
        writer.close();

        return true;
    }
}
