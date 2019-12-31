package com.googol24.java.thread;

/**
 * 线程同步的经典问题 - 生产中消费者问题
 *
 * Object.wait()      - 挂起一个线程
 * Object.notify()    - 唤醒线程（唤醒正在此对象的监视器上等待的一个线程）
 * Object.notifyAll() - 唤醒线程（唤醒正在此对象的监视器上等待的所有线程）
 */
public class TestProducerConsumer {
    public static void main(String[] args) {
        Pool pool = new Pool(6);

        Producer producer = new Producer(pool);
        Consumer consumer = new Consumer(pool);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

/**
 * 食物，也即生产者生产的对象
 */
class Food {
    private int id;

    Food (int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Food:" + id;
    }
}

/**
 * 盛装食物的容器
 */
class Pool {
    private int size;

    private Food[] foods;

    // 栈顶指针
    private int topIndex;

    Pool(int size) {
        this.size = size;
        this.foods = new Food[size];
    }

    synchronized void push(Food food) {
        // 循环容量检查
        while (topIndex >= size) {
            try {
                // 当缓冲区满时，缓冲区调用wait()方法，使得生产者释放锁，当前线程阻塞
                // 直到某个其他线程在同一个对象上调用notify() 或notifyAll()，该线程才会进入就绪状态
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 当缓冲区未满时，生产者生产商品放入缓冲区，
        // 然后缓冲区调用notify()方法，通知上一个因wait()方法释放锁的线程现在可以去获得锁了，
        // 同步块代码执行完成后，释放对象锁，此处的对象锁，锁住的是缓冲区
        this.notify();

        this.foods[topIndex] = food;
        topIndex++;
    }

    synchronized Food pop() {
        // 循环容量检查
        while (topIndex <= 0) {
            try {
                // 缓冲区空时，缓冲区调用wait()方法，使得消费者释放锁，当前线程阻塞
                // 直到某个其他线程在同一个对象上调用notify() 或notifyAll()，该线程才会进入就绪状态
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 当缓冲区不为空时，消费者从缓冲区中取出商品，
        // 然后缓冲区调用notify()方法，通知上一个因wait()方法释放锁的线程现在可以去获得锁了，
        // 同步块代码执行完成后，释放对象锁
        this.notify();

        topIndex--;
        return foods[topIndex];
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private Pool pool;

    Producer(Pool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Food food = new Food(i);
            this.pool.push(food);
            System.out.println("生产了" + food);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    private Pool pool;

    Consumer(Pool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Food f = this.pool.pop();
            System.out.println("消费了" + f);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
