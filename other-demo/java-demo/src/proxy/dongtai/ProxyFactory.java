package proxy.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserProxyFactory
 * @Description: 动态代理对象 工厂 动态代理实现方式1
 * @Author: zhangdi
 * @Date: 2020年05月26日 14:08
 **/
public class ProxyFactory {
    /**
     * 维护一个目标对象
     */
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象生成代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        // target.getClass().getClassLoader() 获取当前class的类装载器
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");

                        // 执行目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("提交事务");
                        return null;
                    }
                });
    }
}
