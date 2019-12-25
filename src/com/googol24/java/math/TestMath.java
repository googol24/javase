package com.googol24.java.math;

/**
 * java.lang.Math 提供了一系列静态方法用于数学计算，其方法的参数和返回值类型一般为double类型
 */
public class TestMath {
    public static void main(String[] args) {
        System.out.println(Math.abs(-1.234));
        System.out.println(Math.sqrt(36));

        // pow(a,b) a的b次方
        System.out.println(Math.pow(2, 3));

        // log(a) 自然对数(e为底)
        System.out.println(Math.log(Math.E));
        System.out.println(Math.exp(10));
        System.out.println(Math.pow(Math.E, 10));

        // random() 返回0~1之间的随机数
        System.out.println(Math.random());

        // round() 四舍五入
        System.out.println(Math.round(4.7));
    }
}
