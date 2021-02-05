package com.example.springbootdemofileuploadclient.service;

import com.example.springbootdemofileuploadclient.config.MultipartSupportConfig;
import com.example.springbootdemofileuploadclient.service.impl.FileUploadFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @ProjectName: model-parent
 * @ClassName: IWorkflowService
 * @Description: 工作流微服务调用接口
 * @Author: zhangdi
 * @Date: 2020年05月09日 16:24
 **/
@FeignClient(value = "bpm", configuration = MultipartSupportConfig.class, fallbackFactory = FileUploadFallback.class)
public interface IBpmImporterService {
    /**
     * 导入流程文件
     *
     * @param file 文件
     * @return 导入结果
     */
    @RequestMapping(value = "/bpm/wf/info-process-model/importForModelDesigner", method = RequestMethod.POST, consumes =
            {MediaType.MULTIPART_FORM_DATA_VALUE})
    Map<String, Object> importModel(@RequestPart(value = "file") MultipartFile file);

    /**
     * 导入流程文件
     *
     * @param file 文件
     * @return 导入结果
     */
    @RequestMapping(value = "/bpm/wf/info-process-model/testUpload", method = RequestMethod.POST, consumes =
            {MediaType.MULTIPART_FORM_DATA_VALUE})
    String testUpload(@RequestPart(value = "file") MultipartFile file);
}
