package com.googol24.java.oo;

/**
 * 构造函数和一般成员函数在继承中的区别
 */
class A {
    protected void print(String s) {
        System.out.println(s);
    }

    A() {
        this.print("A()");
    }

    public void f() {
        print("A:f()");
    }
}

public class B extends A{
    B() {
        print("B()");
    }

    @Override
    public void f() {
        print("B:f()");
    }

    public static void main(String[] args) {
        B b = new B();
        b.f();
    }
}
