package com.googol24.java.thread;

/**
 * 线程
 *
 * 线程是一个粗鞥徐内部的顺序控制流（可以理解成分支或者执行路径）
 * 线程与进程的区别：
 *      -> 每个进程都有独立的代码和数据空间（进程上线文），进程之间的切换会有较大的开销
 *      -> 线程可以看成是轻量级的进程，同一类线程（属于同一个进程的线程）共享代码和数据空间，
 *         每个线程有独立的运行栈和程序计数器（PC），线程之间的切换开销比较小
 *
 * 多进程：在OS中能同时运行多个任务（程序）
 * 多线程：在同一应用中有多个顺序流同时执行
 * 多线程并发执行：微观角度上，对于单核CPU来说，在具体的某一时间点只有一个线程在被调度。只是CPU把自己的执行时间片
 *              划分到每一个线程，宏观上看起来就好像是多个线程在并行执行一样，实际上是在并发执行
 *
 * Java的线程是通过java.lang.Thread类来实现的
 *      -> VM启动的时候会有一个main方法定义的线程（主线程）
 *      -> 可以通过创建Thread的实例来创建新的线程
 *      -> 每个线程都是通过某个特定的Thread对象所对应的run方法来完成其操作的，方法run()称为线程体，也即线程执行的业务逻辑
 *      -> 通过调用Thread类实例的start()方法来启动一个线程，从而线程开始执行
 *
 *  线程的创建和启动：Java中有两种方法创建一个新的线程
 *      -> 第一种：定义线程类实现Runnable接口
 *               Thread myThread = new Thread(target) // target为Runnable接口类型
 *               Runnable中只有一个run()方法，用以定义线程运行体
 *               使用Runnable接口可以为多个线程提供共享数据
 *               在实现Runnable的实现类的run方法定义中，可以使用Thread的静态方法 public static Thread currentThread()来获取当前线程的引用
 *
 *      -> 第二种：可以定义一个Thread的子类并重写其run()方法。注意：Thread类本身也实现了Runnable
 *               class MyThread extends Thread {
 *                   @Override
 *                   public void run() {
 *                       ......
 *                   }
 *               }
 *               然后生成该类的对象：MyThread t = new MyThread(...)
 *
 *
 */
public class TestThread1 {
    public static void main(String[] args) {
        Runner1 r = new Runner1();
        Thread t = new Thread(r);

//        // 注意：直接调用t的run方法，不是启动线程，而是一个普通的方法调用
//        t.run();

        // 启用线程
        t.start();

        // main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}

/**
 * 实现了Runnable接口，表示这是一个线程类
 */
class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner1: " + i);
        }
    }
}
