package synchronizedpkg;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestSynchronized4
 * @Description: 验证：两个线程同时访问同一个对象的不同的同步方法时，是线程安全的。
 * @Author: zhangdi
 * @Date: 2020年11月26日 09:27
 **/
public class TestSynchronized6 implements Runnable {
    static TestSynchronized6 instance = new TestSynchronized6();


    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("测试结束：两个线程同时访问同一个对象的不同的同步方法时，是线程安全的。");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            //线程0,执行同步方法method0()
            method0();
        }
        if (Thread.currentThread().getName().equals("Thread-1")) {
            //线程1,执行同步方法method1()
            method1();
        }
    }

    private synchronized void method0() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，同步方法0，运行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "，同步方法0，运行结束");
    }

    private synchronized void method1() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，同步方法1，运行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "，同步方法1，运行结束");
    }
}