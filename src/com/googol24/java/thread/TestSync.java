package com.googol24.java.thread;

/**
 * 线程同步
 */
public class TestSync implements Runnable {
    private Timer timer = new Timer();

    public static void main(String[] args) {
        TestSync test = new TestSync();

        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);

        t1.setName("T1");
        t2.setName("T2");

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        this.timer.add(Thread.currentThread().getName());
    }
}

class Timer {
    private static int num = 0;

    void add(String name) {
        // 锁定当前对象this，也就锁定了成员变量num
        synchronized (this) {
            num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("当前线程被打断");
            }

            System.out.println(name + ", 你是第" + num + "个使用timer的进程");
        }
    }

//    // 在执行这个方法的过程中，当前对象被锁定，也就锁定了成员变量num
//    synchronized void add(String name) {
//        num++;
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            System.out.println("当前线程被打断");
//        }
//
//        System.out.println(name + ", 你是第" + num + "个使用timer的进程");
//    }

}
