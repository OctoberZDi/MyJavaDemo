package synchronizedpkg;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestSynchronized2
 * @Description: 验证：两个线程同时访问（一个或两个）对象的静态同步方法，是线程安全的。
 * @Author: zhangdi
 * @Date: 2020年11月25日 16:50
 **/
public class TestSynchronized3 implements Runnable {
    public TestSynchronized3(String threadName) {
        this(threadName, 100);
    }

    public TestSynchronized3(String threadName, Integer poolSize) {
        System.out.println(threadName + poolSize);
    }

    /**
     * 创建两个不同的对象
     */
    static TestSynchronized3 instance1 = new TestSynchronized3("instance1");
    static TestSynchronized3 instance2 = new TestSynchronized3("instance2");

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }

        System.out.println("测试结束:两个线程同时访问（一个或两个）对象的静态同步方法，是线程安全的");
    }

    @Override
    public void run() {
        test();
    }

    /**
     * 同步方法用static修饰，线程安全
     */
    private synchronized static void test() {
        System.out.println("线程名：" + Thread.currentThread().getName() + " 运行开始！");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名：" + Thread.currentThread().getName() + " 运行结束！");
    }
}