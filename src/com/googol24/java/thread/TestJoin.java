package com.googol24.java.thread;

/**
 * 线程控制方法 join
 */
public class TestJoin {
    public static void main(String[] args) {
        // main线程启动子线程
        MyThread2 thread2 = new MyThread2("sub thread2");
        thread2.start();

        // main线程合并子线程。即等待子线程结束，再恢复到main线程运行
        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("主线程被打断");
        }

        // main线程的其他处理逻辑
        for (int i = 0; i < 10; i++) {
            System.out.println("I am Main Thread");
        }

    }
}

class MyThread2 extends Thread {
    MyThread2(String name) {
        super(name);
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("I am " + getName());

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("子当前线程被打断");
                // 子线程执行结束
                return;
            }
        }
    }
}
