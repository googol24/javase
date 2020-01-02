package com.googol24.java.reflection;

/**
 * Java 反射机制
 *
 * java程序运行过程：
 *      -> .class被ClassLoader加载到内存的code seg，运行环境然后找main函数开始执行，由于动态加载机制，在运行过程中会有很多类被加载进来
 *
 * ClassLoader的动态加载机制：
 *      -> 在运行中所需要的类并不是一次性加载，而是在需要的时候加载（动态加载机制）
 *      -> java -verbose:class 可以查看类的具体加载过程(VM options)
 *
 * 语句块的加载执行：
 *      -> static语句块会在类加载后一次执行
 *      -> dynamic语句块会在每次new新对象的时候都会执行（等同于构造方法中的语句）
 *
 */
public class TestReflection {
    public static void main(String[] args) {
        // 在动态运行的时候会先加载A，再加载B
        new A();
        System.out.println("**------------------------------------------------------**");
        new B();

        new C();
        new C();

        new D();
        new D();

        new E();
    }
}

class A {

}

class B {

}

class C {
    // 静态语句块
    static {
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
    }
}

class D {
    // 动态语句块
    {
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
    }
}

class E {

}


