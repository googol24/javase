package com.googol24.java.oo;

/**
 * final 关键字
 *
 * final修饰的变量的值不能被改变（或者设置）
 *      -> final的成员变量
 *      -> final的局部变量（形参）
 * final修饰的方法不能被重写
 * final修饰的类不能被继承
 */
public class TestFinal {
    public static void main(String[] args) {
        TF tf = new TF();
        //tf.i = 8;// error, final类型的变量不能被改变
    }
}

class TF {
    final int i = 8;

    public void f(final int j) { // 实参一旦传递过来，就不允许在方法体中改变其值
        //j = 8;// error, final类型的变量不能被改变
    }

    public final void m() {

    }
}

class SubTF extends TF {
//    public void m() {// error, final类型的方法不能被重写
//
//    }
}

final class FinalT {}

//class SubFinalT extends FinalT {}// error, final类型的类不能被继承
