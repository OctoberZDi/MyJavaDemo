package proxy;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserServiceImpl
 * @Description: 目标对象
 * @Author: zhangdi
 * @Date: 2020年05月26日 13:58
 **/
public class UserServiceImpl implements IUserService {
    @Override
    public void say() {
        System.out.println("hello everyone,welcome to proxy....");
    }
}
