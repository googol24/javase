package com.googol24.java.thread;

import java.util.Date;

/**
 * 线程控制的一些基本方法介绍-1
 *
 * sleep方法
 *      -> 可以调用Thread类的静态方法 public static void sleep(long millis) throws InterruptException 使得当前线程休眠millis毫秒，
 *         当然也可以指定纳秒（第二个参数）
 *      -> 由于是静态方法，可以直接由类名调用：Thread.sleep(...)。当某个线程类继承Thread的时候需要休眠自己的时候，可以直接sleep(...)
 *
 * join方法
 *      -> 合并某个线程。调用某个线程的该方法，将当前线程与该线程合并，即等待该线程结束，再恢复当前线程运行
 *
 * yield方法
 *      -> 让出CPU，给其他线程执行机会
 */
public class TestInterrupt {
    public static void main(String[] args) {
        // main 创建并启动子线程
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();

        // main 休眠10s
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("主线程被打断！");
            System.exit(-1);
        }

        // 主线程main调用子线程的interrupt()方法打断子线程
        thread.interrupt();
//        myThread.setFlag(false);
    }
}

/**
 * 子线程类
 */
class MyThread implements Runnable {

//    private boolean flag = true;
//
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }

    @Override
    public void run() {
        while (true) {
//        while (flag) {
            System.out.println("==== " + new Date() + " ====");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("当前子线程被打断！");
                // 线程执行结束
                return;
            }
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        try {
            // 父类的静态方法
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
