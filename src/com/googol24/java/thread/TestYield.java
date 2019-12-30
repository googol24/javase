package com.googol24.java.thread;

/**
 * 线程控制方法 yield
 */
public class TestYield {
    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3("T1");
        MyThread3 t2 = new MyThread3("T2");

        // 主线程启动两个子线程T1 T2
        t1.start();
        t2.start();
    }
}

class MyThread3 extends Thread {
    MyThread3(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + ":" + i);

            // 执行索引编号i是10的倍数时，一定会发生线程让权
            // 正在执行的线程会让出CPU，进入就绪队列等待调度
            // 注意：让步的线程还有可能被线程调度程序再次选中
            if (i % 10 == 0) {
                System.out.println(getName() + "让出执行权");
                yield();
            }
        }
    }
}
