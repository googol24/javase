package com.googol24.java.thread;

/**
 * 线程的优先级别
 *
 * Java提供一个线程调度器来监控程序中启动后进入就绪状态的所有线程
 * 线程调度器按照线程的优先级别决定应调度哪个线程来执行
 *
 * 线程的优先级用数字表示，范围从1到10。一个线程的默认优先级是5
 *      -> Thread.MIN_PRIORITY = 1, Thread.MAX_PRIORITY = 10, Thread.NORM_PRIORITY = 5
 *      -> 获得或者设置线程的优先级的成员方法：int getPriority() / void setPriority(int newPriority)
 */
public class TestPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());

        System.out.println("T1的优先级：" + t1.getPriority());
        System.out.println("T2的优先级：" + t2.getPriority());

        // 设置优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("T1的优先级：" + t1.getPriority());
        System.out.println("T2的优先级：" + t2.getPriority());

        t1.start();
        t2.start();
    }
}

class T1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("T1: " + i);
        }
    }
}

class T2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("----T2: " + i);
        }
    }
}