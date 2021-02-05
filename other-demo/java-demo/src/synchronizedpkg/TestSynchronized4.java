package synchronizedpkg;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestSynchronized4
 * @Description: 验证：两个线程分别同时访问（一个或两个）对象的同步方法和非同步方法，是线程不安全的。
 * @Author: zhangdi
 * @Date: 2020年11月26日 09:27
 **/
public class TestSynchronized4 implements Runnable {
    static TestSynchronized4 testSynchronized4 = new TestSynchronized4();

    public static void main(String[] args) {
        Thread thread1 = new Thread(testSynchronized4);
        Thread thread2 = new Thread(testSynchronized4);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("测试结束:两个线程分别同时访问（一个或两个）对象的同步方法和非同步方法，是线程不安全的。");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            //线程0,执行同步方法method0()
            method0();
        }
        if (Thread.currentThread().getName().equals("Thread-1")) {
            //线程1,执行非同步方法method1()
            method1();
        }
    }

    /**
     * 同步方法
     */
    public synchronized void method0() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，同步方法，运行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "，同步方法，运行结束");
    }

    /**
     * 普通方法
     */
    public void method1() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，普通方法，运行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "，普通方法，运行结束");
    }
}