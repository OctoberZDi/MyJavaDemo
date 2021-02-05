package com.example.springclouddemoprovider8080.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserService
 * @Description:
 * @Author: zhangdi
 * @Date: 2020年05月16日 10:48
 **/
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;
    static final String JWT_SERVICE_URL = "http://jwt-service/user/getById/{id}";

    public Object getUserByid(String id) {
    /*    Object forObject = restTemplate.getForObject(JWT_SERVICE_URL, Map.class, id);

        ResponseEntity<Map> forEntity = restTemplate.getForEntity(JWT_SERVICE_URL, Map.class, id);
        System.out.println(forEntity.getHeaders());
        System.out.println(forEntity.getBody());
        System.out.println(forEntity.getStatusCode());
*/
        LinkedMultiValueMap<Object, Object> header = new LinkedMultiValueMap<>();
        header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(header);
        ResponseEntity<Map> forEntity1 = restTemplate.exchange(JWT_SERVICE_URL, HttpMethod.GET, objectHttpEntity, Map.class, id);
        System.out.println(forEntity1);

        return forEntity1;
    }
}
