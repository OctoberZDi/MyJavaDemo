package com.zd.demo.hutooldemo.excel;

import java.io.IOException;

/**
 * @ProjectName: codes-generator
 * @ClassName: IExcelService
 * @Description: excel生成service
 * @Author: zhangdi
 * @Date: 2020年02月19日 14:10
 **/
public interface IExcelService {
    /**
     * 客户端下载xls格式的excel
     */
    void exportXlsToClient(Iterable<?> data) throws IOException;

    /**
     * 客户端下载xlsx格式的excel
     */
    void exportXlsxToClient(Iterable<?> data) throws IOException;

    /**
     * 导出excel到指定路径
     *
     * @return 导出成功true；导出失败：false;
     */
    boolean exportToPath(Iterable<?> data, String destFilePath);
}
