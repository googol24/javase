package com.googol24.java.thread;

/**
 * 练习 synchronized
 */
public class Practice2 {
    public static void main(String[] args) {
        SyncClass syncObj = new SyncClass();
        Thread t = new Thread(syncObj);

        t.start();

        // 执行同步方法时，syncObj为被同步的对象

        syncObj.m2();

//        // 修饰方法时锁定的是调用该方法的对象，即如果一个对象中有两个方法同时被synchronized，
//           则同一个对象，调用这两个方法时，同一时刻只能执行一个。不同对象则不会
//        new SyncClass().m2();
    }
}

class SyncClass implements Runnable {
    static int b = 100;

    public synchronized void m1() throws Exception {
        b = 200;
        Thread.sleep(5000);
        System.out.println("b = " + b);
    }

//    public void m2() {
    public synchronized void m2() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {}

        // 非同步方法的时候，会读到被m1()修改之后的b=200
        // 改为同步的时候，对象syncObj被锁定，就不会出现这种现象
        System.out.println(b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
