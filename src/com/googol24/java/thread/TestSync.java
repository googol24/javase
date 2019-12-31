package com.googol24.java.thread;

/**
 * 线程同步
 *
 * 在Java中，引入了对象互斥锁的概念，保证共享数据操作的完整性。
 * 每个对象都对应于一个可称为“互斥锁”的标记，这个标记保证在任一时刻只能有一个线程访问该对象
 *
 * 关键字synchronized用来与对象的互斥锁联系。当某个对象用synchronized修饰时，表明该对象在任一时刻只能有一个线程访问
 * 当synchronized修饰某个方法的时候，某个线程在执行这个方法体时，其他线程还是可以访问其他未锁定的方法的
 *      -> 注意：synchronized修饰方法时锁定的是调用该方法的对象（其他线程调用该对象的任何同步方法的时候都必须等待这个锁的释放）
 *              即如果一个对象中有两个方法同时被synchronized，则同一个对象，调用这两个方法时，同一时刻只能执行一个
 *      -> 注意：调用synchronized方法的对象可以同时调用未被synchronized修饰的方法（调用非同步方法不影响对象锁定）
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
