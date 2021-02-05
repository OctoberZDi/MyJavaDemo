package synchronizedpkg;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestSynchronized4
 * @Description: 验证：只有当同步方法执行完或执行时抛出异常这两种情况，才会释放锁。
 * @Author: zhangdi
 * @Date: 2020年11月26日 09:27
 **/
public class TestSynchronized8 implements Runnable {
    static TestSynchronized8 instance = new TestSynchronized8();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            //线程0,执行抛异常方法method0()
            method0();
        }
        if (Thread.currentThread().getName().equals("Thread-1")) {
            //线程1,执行正常方法method1()
            method1();
        }
    }

    private synchronized void method0() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，运行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //同步方法中，当抛出异常时，JVM会自动释放锁，不需要手动释放，其他线程即可获取到该锁
        System.out.println("线程名：" + Thread.currentThread().getName() + "，抛出异常，释放锁");
        throw new RuntimeException();

    }

    private synchronized void method1() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，运行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "，运行结束");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("测试结束:只有当同步方法执行完或执行时抛出异常这两种情况，才会释放锁。");
    }
}
