package proxy.dongtai;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ProxyFactory2
 * @Description: 动态代理实现方式2 cglib
 * @Author: zhangdi
 * @Date: 2020年05月26日 16:23
 **/
public class ProxyFactory2 implements MethodInterceptor {

    private Object target;

    public ProxyFactory2(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        // 工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调
        enhancer.setCallback(this);
        // 创建子对象代理
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object invoke = method.invoke(target, objects);
        System.out.println("关闭事务");
        return null;
    }
}
