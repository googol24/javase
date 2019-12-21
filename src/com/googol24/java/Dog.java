package com.googol24.java;

/**
 * 类是静态的概念，存放于内存的代码区
 * 对象是new出来的，位于堆内存，类的每个成员变量在不同的对象中个都有不同的值（除了静态变量），因而有不同的成员变量存储空间，而方法只有一份，执行的时候才占用内存
 */
public class Dog {
    // 成员变量未指定默认值的时候Java会默认给它初始化（局部变量使用之前必须定义并且初始化）
    // 成员变量的作用范围为整个类体
    private int furColor;
    private float height;
    private float weight;

    // 未指定构造方法时Java自动添加的构造方法
    private Dog() {

    }

    // 自定义的构造方法
    // 一旦自己定义了构造方法，java就不再为该类添加默认构造方法 Dog(){}
    Dog(int _furColor, int _height, int _weight) {
        furColor = _furColor;
        height = _height;
        weight = _weight;
    }

    void catchMouse(Mouse m) {
        System.out.println("I am catching a mouse '" + m.getName() + "'");
        m.scream();
    }

    public static void main(String args[])
    {
        Dog d = new Dog();
        Mouse m = new Mouse("jerry");

        d.catchMouse(m);
    }
}

class Mouse {
    private String name;

    Mouse(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void scream() {
        System.out.println("ah ~");
    }
}