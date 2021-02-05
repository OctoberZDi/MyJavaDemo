package com.example.springbootdemofileuploadclient.service.impl;

import com.example.springbootdemofileuploadclient.service.IBpmImporterService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @ProjectName: model-parent
 * @ClassName: BpmFallbackService
 * @Description: 服务降级
 * @Author: zhangdi
 * @Date: 2020年05月14日 11:18
 **/
@Component
public class BpmImporterFallbackService implements FallbackFactory<IBpmImporterService> {

    Logger log = LoggerFactory.getLogger(BpmImporterFallbackService.class);

    /**
     * IBpmService的降级处理方法
     *
     * @param throwable 异常
     * @return bpm service
     */
    @Override
    public IBpmImporterService create(Throwable throwable) {
        return new IBpmImporterService() {
            @Override
            public Map<String, Object> importModel(MultipartFile file) {
                log.error("无法导入流程文件！服务调用异常或服务尚未开启！参数:【{}】错误信息：【{}】", file.getName(), throwable.getMessage());
                return null;
            }

            /**
             * 导入流程文件
             *
             * @param file 文件
             * @return 导入结果
             */
            @Override
            public String testUpload(MultipartFile file) {
                log.error("测试失败！参数:【{}】错误信息：【{}】", file.getName(), throwable.getMessage());
                return null;
            }
        };
    }
}
