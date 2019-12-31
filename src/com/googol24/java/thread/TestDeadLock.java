package com.googol24.java.thread;

/**
  线程同步问题之 死锁

        死锁是这样一种情形：多个线程同时被阻塞，它们中的一个或者全部都在等待某个资源被释放。由于线程被无限期地阻塞，因此程序不可能正常终止。

        java 死锁产生的四个必要条件：
        1、互斥使用，即当资源被一个线程使用(占有)时，别的线程不能使用
        2、不可抢占，资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放。
        3、请求和保持，即当资源请求者在请求其他的资源的同时保持对原有资源的占有。
        4、循环等待，即存在一个等待队列：P1占有P2的资源，P2占有P3的资源，P3占有P1的资源。这样就形成了一个等待环路。
 */
public class TestDeadLock {
    public static void main(String[] args) {
        DeadLockClass deadLockObj = new DeadLockClass();
        Thread t1 = new Thread(deadLockObj);
        Thread t2 = new Thread(deadLockObj);

        t1.setName("T1");
        t2.setName("T2");

        t1.start();
        t2.start();

        // 死锁解决：在不考虑性能的前提下，可以加一个粗粒度的锁，避免锁多个对象
    }
}

/**
 * 模拟死锁的类
 */
class DeadLockClass implements Runnable {
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    private enum Name{T1, T2}

    @Override
    public void run() {
        System.out.println("current thread:" + Thread.currentThread().getName());

        if (Thread.currentThread().getName().equals(Name.T1.toString())) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("当前线程 " + Thread.currentThread().getName() + " 被打断！");
                }

                synchronized (o2) {
                    System.out.println("当前线程 " + Thread.currentThread().getName() + " 执行完毕！");
                }
            }
        } else if(Thread.currentThread().getName().equals(Name.T2.toString())) {
            synchronized (o2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("当前线程 " + Thread.currentThread().getName() + " 被打断！");
                }

                synchronized (o1) {
                    System.out.println("当前线程 " + Thread.currentThread().getName() + " 执行完毕！");
                }
            }
        }
    }
}
