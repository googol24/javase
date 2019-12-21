package com.googol24.java.oo;

public class TestAccess {
    public static void main(String args[]) {

    }
}

/**
 * 访问控制符（权限修饰符），可用于修饰类、成员变量或者成员方法
 *
 * 修饰符       类内部可访问    同一个包内可访问       子类可访问      任何地方都可以访问
 * private     yes          no                  no            no
 * 默认         yes          yes                 no            no
 * protected   yes          yes                 yes           no
 * public      yes          yes                 yes           yes
 */
class T {
    private int i = 0;
    int j = 0;//default 权限，或者叫包权限（位于同一个包里面的其他类可以访问default成员变量）
    protected int k = 0;
    public int m = 0;

    public void m() {
        this.i = 9;
    }
}

class TT {
    public void m() {
        T t = new T();
        System.out.println(t.m);
    }
}
