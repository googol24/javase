package com.googol24.java.thread;

public class Practice1 {
    public static void main(String[] args) {
//        Thread t = new Thread(
//                new Thread1()
//        );
//
//        t.start();

        Thread t2 = new Thread(new Thread2());
        t2.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("MainThread: " + i);
        }
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 200; i++) {
            System.out.println("==== sub thread ====" + i);
            if (i != 0 && i % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("子线程被打断");
                }
            }
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        // 当前线程是否还活着
        System.out.println(Thread.currentThread().isAlive());

        for (int i = 0; i < 50; i++) {
            System.out.println("SubThread: " + i);
        }
    }
}
