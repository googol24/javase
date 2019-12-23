package com.googol24.java.oo;

/**
 * 接口测试demo
 */
interface Valuable {
    public double getMoney();
}

interface Protectable {
    public void beProtected();
}

// 类和类之间可以相互继承，接口与接口之间也可以相互继承，但是类只能实现接口
interface AInterface extends Protectable {
    void m();
}

abstract class Animal2 {
    private String name;

    abstract void enjoy();
}

class GoldenMonkey extends Animal2 implements Valuable, Protectable {
    @Override
    public double getMoney() {
        return 10000;
    }

    @Override
    public void beProtected() {
        System.out.println("live in the room");
    }

    @Override
    void enjoy() {

    }
}

class Hen implements AInterface {
    @Override
    public void beProtected() {

    }

    @Override
    public void m() {

    }
}

public class TestInterface2 {
    public static void main(String[] args) {

    }
}
