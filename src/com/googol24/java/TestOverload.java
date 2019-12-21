package com.googol24.java;

/**
 * 方法重载:一个类中可以有多个方法名和返回类型相同，但是方法参数类型或者参数个数不一样的多个方法（不适用于方法返回类型不同的情况）
 * 构造方法也可以重载
 */
public class TestOverload {

    public void max(int a, int b) {
        System.out.println(a >= b ? a : b);
    }

    public void max(int a, int b, int c) {
        int result = a;

        int[] arr = new int[]{a, b, c};

        for (int item : arr) {
            if (item > result) {
                result = item;
            }
        }

        System.out.println(result);
    }

    public void max(short a, short b) {
        System.out.println("short max:" + (a >= b ? a : b));
    }

    public void max(float a, float b) {
        System.out.println(a >= b ? a : b);
    }

    public static void main(String args[]) {
        TestOverload t = new TestOverload();
        t.max(3, 4);
        t.max(7f, 5.0f);
        short a = 4;
        short b = 5;
        t.max(a, b);
        t.max(5, 9, 7);

        People p1 = new People();
        p1.display();

        People p2 = new People(2);
        p2.display();

        People p3 = new People(3, "zhangsan");
        p3.display();
        p3.getThis().display();
    }
}

class People{
    int id;

    String name;

    // this:一个变量，值是[当前对象(调用含this的方法的这个对象)]的一个引用
    People() {
        this.id = 1;
        this.name = "unknown";
    }

    People(int id) {
        this.id = id;
        this.name = "unknown";
    }

    People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    People getThis(){
        System.out.print("this: ");
        return this;
    }

    void display() {
        System.out.println("id:" + this.id + ", name:" + this.name);
    }
}
