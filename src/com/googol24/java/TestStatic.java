// 需要把类放入包里面是，需要使用package指定包：只能写在第一句，编译出来的class文件必须位于正确的目录（目录层次与包一致）
// 访问同一个包下面的类的时候，不需要import，否则需要import其他包下的该类
// java.lang包里面的类不需要引入即可以直接使用（比如 System类，String类），其他的包不行
package com.googol24.java;

/**
 * 在类中，用static声明的成员变量称为静态成员变量，为该类的公用变量，在第一次使用时被初始化。对该类的所有对象来说，static成员变量只有一份（static属性也可以用对象去访问或修改）
 * 静态变量存放在内存的数据区
 * 用static声明的成员方法为静态方法。在调用该方法时，不会将对象的引用传递给它，所以在static方法中不能访问非static的成员（必须new一个对象来访问非静态成员）
 */
public class TestStatic {
    public static void main(String[] args){
        Cat c = new Cat();
        c.sid = 2;// Cat.sid=2;

        c.show();

        Cat c2 = new Cat();
        c.show();
    }
}

class Cat {
    Cat() {
        this.id = sid ++;
    }

    static int sid = 0;

    int id;

    void show() {
        System.out.println("id:" + this.id + ", sid:" + sid);
    }
}
