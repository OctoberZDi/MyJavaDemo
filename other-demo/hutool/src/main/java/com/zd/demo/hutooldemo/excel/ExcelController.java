package com.zd.demo.hutooldemo.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ProjectName: codes-generator
 * @ClassName: ExcelController
 * @Description: Excel操作相关控制类
 * @Author: zhangdi
 * @Date: 2020年02月19日 10:57
 **/
@RestController
@RequestMapping(value = "excel")
public class ExcelController {

    @Autowired
    private ExcelServiceImpl excelService;

    public String test(HttpServletRequest request, HttpServletResponse response, String fileName) throws Exception {
        /*String columnObject = getParameter("columnObject");//字段对应关系
        JSONArray myJsonArray = JSONArray.parseArray(columnObject);
        HSSFRow row = sheet.createRow((int) 0);
        for (int i = 0; i < myJsonArray.size(); i++) {
            JSONObject newColumn = (JSONObject) myJsonArray.get(i);
            String colName = (String) newColumn.get("title");
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(colName);
        }

        for (int i = 0; i < pagin.getResultList().size(); i++) {
            Map<String, Object> newMap = ConvertObjToMap(pagin.getResultList().get(i));
            row = sheet.createRow((int) i + 1);
            for (int j = 0; j < myJsonArray.size(); j++) {
                JSONObject newColumn = (JSONObject) myJsonArray.get(j);
                String col = (String) newColumn.get("dataIndex");
                String valueNew = String.valueOf(newMap.get(col));
                row.createCell(j).setCellValue(valueNew);
            }
        }*/
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("工作表1");
        sheet.setDefaultColumnWidth(18);
        sheet.setDefaultRowHeightInPoints(20);
        String newFileName = fileName + ".xls";
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(newFileName, "UTF-8"));
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

        return "";
    }

    /**
     * 导出excel，格式为xls（适用于客户端下载导出）
     *
     * @return 导出响应结果
     */
    @RequestMapping(value = "exportXls")
    public String exportXls() throws IOException {
        excelService.exportXlsToClient(null);

        return "";
    }

    /**
     * 导出excel，格式为xlsx（适用于客户端下载导出）
     *
     * @return 导出响应结果
     */
    @RequestMapping(value = "exportXlsx")
    public String exportXlsx() throws IOException {
        excelService.exportXlsxToClient(null);

        return "";
    }

    /**
     * 导出excel到指定路径
     *
     * @return 导出响应结果
     */
    @RequestMapping(value = "exportToPath")
    public String exportToPath() {
        excelService.exportToPath(null, "");

        return "";
    }
}
