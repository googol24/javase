package com.googol24.java.thread;

import java.util.*;

/**
 * 生产者消费者问题2
 *
 * 多个生产者和多个消费者的情形
 */
public class TestProducerConsumer2 {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Thread pThread1 = new Thread(new Producer2(storage));pThread1.setName("pThread1");
        Thread pThread2 = new Thread(new Producer2(storage));pThread2.setName("pThread2");
        Thread pThread3 = new Thread(new Producer2(storage));pThread3.setName("pThread3");

        Thread cThread1 = new Thread(new Consumer2(storage));cThread1.setName("cThread1");
        Thread cThread2 = new Thread(new Consumer2(storage));cThread2.setName("cThread2");
        Thread cThread3 = new Thread(new Consumer2(storage));cThread3.setName("cThread3");

        pThread1.start();
        pThread2.start();
        pThread3.start();

        cThread1.start();
        cThread2.start();
        cThread3.start();
    }
}

class Storage {

    // 仓库容量
    private static final int MAX_SIZE = 10;

    // 仓库存储的载体
    private final LinkedList<Object> list = new LinkedList<>();

    // 向仓库中生产产品
    void produce() {
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("【生产者" + Thread.currentThread().getName() + "】仓库已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName() + "】生产一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }

    // 从仓库中消费产品
    void consume() {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("【消费者" + Thread.currentThread().getName() + "】仓库为空");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【消费者" + Thread.currentThread().getName() + "】消费一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }
}

/**
 * 生产者
 */
class Producer2 implements Runnable {
    private Storage storage;


    Producer2(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer2 implements Runnable {
    private Storage storage;

    Consumer2(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                storage.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
