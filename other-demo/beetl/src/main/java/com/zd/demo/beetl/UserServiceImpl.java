package com.zd.demo.beetl;

import com.zd.demo.beetl.service.IAnimalService;
import com.zd.demo.beetl.service.IUserService;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserServiceImpl
 * @Description: 测试接口的时候
 * @Author: zhangdi
 * @Date: 2020年02月16日 20:22
 **/
public class UserServiceImpl implements IUserService, IAnimalService {

    @Override
    public boolean canEat() {
        return false;
    }

    @Override
    public void getName() {
        System.out.println("this is getName ...");
    }
}
