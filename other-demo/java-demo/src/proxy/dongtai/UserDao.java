package proxy.dongtai;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserServiceImpl
 * @Description: 目标对象
 * @Author: zhangdi
 * @Date: 2020年05月26日 14:07
 **/
public class UserDao implements IUserDao {
    @Override
    public void say(String sth) {
        System.out.println("say " + sth);
    }
}
