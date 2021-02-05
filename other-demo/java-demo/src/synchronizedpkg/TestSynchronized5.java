package synchronizedpkg;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestSynchronized4
 * @Description: 两个线程分别同时访问（一个或两个）对象的同步方法和非同步方法，是线程不安全的
 * @Author: zhangdi
 * @Date: 2020年11月26日 09:27
 **/
public class TestSynchronized5 implements Runnable {
    static TestSynchronized5 instance = new TestSynchronized5();


    public static void main(String[] args) {
        // 此线程直接调用普通方法
        Thread thread0 = new Thread(instance);
        // 这两个线程直接调用同步方法
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread0.start();
        thread1.start();
        thread2.start();
        while (thread0.isAlive() || thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("测试结束：两个线程访问同一个对象中的同步方法，同步方法又调用一个非同步方法，仅在没有其他线程直接调用非同步方法的情况下，是线程安全的。若有其他线程直接调用非同步方法，则是线程不安全的。");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            //直接调用普通方法
            method2();
        } else {
            // 先调用同步方法，在同步方法内调用普通方法
            method1();
        }
    }

    // 同步方法
    private static synchronized void method1() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，同步方法，运行开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "，同步方法，运行结束,开始调用普通方法");
        method2();
    }

    // 普通方法
    private static void method2() {
        System.out.println("线程名：" + Thread.currentThread().getName() + "，普通方法，运行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "，普通方法，运行结束");
    }
}