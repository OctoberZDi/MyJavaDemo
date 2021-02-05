package proxy;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserServiceProxy
 * @Description: 用户服务的静态代理对象，要实现IUserService
 * @Author: zhangdi
 * @Date: 2020年05月26日 13:59
 **/
public class UserServiceProxy implements IUserService {
    IUserService userService;

    public UserServiceProxy(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void say() {
        // 扩展额外功能
        System.out.println("事务开始");
        userService.say();
        System.out.println("事务结束");
    }

    public static void main(String[] args) {
        // 目标对象
        IUserService userService = new UserServiceImpl();
        // 代理对象
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.say();

        System.out.println("*************");
        userService.say();
    }
}
