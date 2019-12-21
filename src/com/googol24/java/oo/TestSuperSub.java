package com.googol24.java.oo;

/**
 * 继承中的构造方法：
 *
 * 子类的构造过程中<必须>调用其基类的构造方法(没父母哪来的孩子)
 * 子类可以在自己的构造方法中使用super(arg_list)调用基类的构造方法
 *      -> 注意：子类的构造方法中可以使用this(arg_list)调用本类的另外构造方法
 *      -> 如果调用了super(arg_list)，必须写在子类构造方法的第一行
 * 如果子类的构造方法中没有显式地调用基类的构造方法，则系统默认调用基类无参数的构造方法
 * 如果子类的构造方法中既没有显式地调用基类的构造方法，且基类中又没有无参数的构造方法，则编译出错
 */
public class TestSuperSub {
    public static void main(String[] args) {
        //SubClass sc1 = new SubClass();
        SubClass sc2 = new SubClass(400);
    }
}

class SupperClass {
    private int n;

    SupperClass() {
        System.out.println("SupperClass()");
    }

    SupperClass(int n) {
        System.out.println("SupperClass(" + n + ")");
        this.n = n;
    }

}

class SubClass extends SupperClass {
    private int n;

    SubClass(int n) {
        // 相当于调用了super()
        System.out.println("SubClass(" + n + ")");
        this.n = n;
    }

    SubClass() {
        super(300);
        System.out.println("SubClass()");
    }
}
