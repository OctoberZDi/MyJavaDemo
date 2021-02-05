package com.example.springbootdemotkmybatis.service;

import com.example.springbootdemotkmybatis.mapper.CgDataSourceMapper;
import com.example.springbootdemotkmybatis.po.CgDataSource;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: HelloService
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年08月26日 16:35
 **/
@Service
public class HelloService {

    @Resource
    CgDataSourceMapper cgDataSourceMapper;

    public List<CgDataSource> sayHello() {
        Example example = new Example(CgDataSource.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("dbType", "oscar");
        return cgDataSourceMapper.selectByExample(example);
    }
}
