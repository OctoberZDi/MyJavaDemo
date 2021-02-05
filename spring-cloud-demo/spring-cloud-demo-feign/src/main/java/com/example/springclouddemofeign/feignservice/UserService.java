package com.example.springclouddemofeign.feignservice;

import com.alibaba.fastjson.JSONObject;
import com.example.springclouddemofeign.config.FeignDecoderConfig;
import com.example.springclouddemofeign.config.FeignEncoderConfig;
import com.example.springclouddemofeign.config.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserRestClient
 * @Description:
 * @Author: zhangdi
 * @Date: 2020年05月16日 16:23
 **/
@FeignClient(value = "provider8080-service", fallbackFactory = UserServiceFallbackFactory.class, configuration =
        {FeignEncoderConfig.class, FeignDecoderConfig.class})
public interface UserService {
    /**
     * @param str
     * @return
     */
    @RequestMapping(value = "/user/getStr/{str}", method = RequestMethod.POST)
    Object getStr2(@PathVariable(value = "str") String str);

    /**
     * @param str
     * @return
     */
    @RequestMapping(value = "/user/getStr/{str}", method = RequestMethod.POST)
    String getStr(@PathVariable(value = "str") String str);

    @RequestMapping(value = "/user/getObj", method = RequestMethod.POST)
    public Object getObject(@RequestBody JSONObject object);
}
