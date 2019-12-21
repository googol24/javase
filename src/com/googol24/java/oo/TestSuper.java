package com.googol24.java.oo;

/**
 * 在Java类中使用super来引用基类的成分
 * 注意:this是表示对当前对象的引用，super是表示对当前对象的父类成分的引用
 */
public class TestSuper {
    public static void main(String[] args) {
        ChildClass cc = new ChildClass();
        cc.f();
    }
}

class FatherClass {
    public int value;

    public void f() {
        value = 100;
        System.out.println("FatherClass.value=" + value);
    }
}

class ChildClass extends FatherClass {
    public int value;

    @Override
    public void f() {
        super.f();

        value = 200;//this.value = 200;
        System.out.println("ChildClass.value=" + value);
        System.out.println(value);
        System.out.println(super.value);
    }
}
