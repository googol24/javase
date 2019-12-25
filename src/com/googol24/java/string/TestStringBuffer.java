package com.googol24.java.string;

/**
 * StringBuffer类
 * java.lang.StringBuffer表示可变的字符序列
 *      -> 注意：String表示不可变的字符序列。与String不同的是，StringBuffer可对其字符串进行改变
 *
 */
public class TestStringBuffer {
    public static void main(String args[]) {
        String s1 = "hello";
        String s2 = "world";

        // String字符序列一旦分配，就不可以对其内容进行改变，要想改变就得重新分配内存空间
        s1 += s2; // 相当于重写分配了一块内存，里面存储的是s1内容与s2内容的连接，效率比较低
        System.out.println(s1);



        // StringBuffer API

        // public StringBuffer append(mixed param)
        // 可以为当前StringBuffer对象添加字符序列，返回添加后的StringBuffer对象引用
        // mixed 表示可以添加String StringBuffer char char[] int double boolean Object等类型
        String s = "Microsoft";
        char[] a = {'a', 'b', 'c'};
        StringBuffer sb1 = new StringBuffer(s);
        sb1.append('/').append("IBM").append('/').append("Sun");
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("数字");
        for (int i = 0; i <=9; i++) {
            sb2.append(i);
        }
        System.out.println(sb2);

        // public StringBuffer insert(int offset, mixed param)
        // 可以为该StringBuffer对象在指定位置插入字符序列，返回修改后的StringBuffer对象引用

        // public StringBuffer delete(int start, int end)
        // 可以删除从start开始到end-1为止的一段字符序列，返回修改后的该StringBuffer对象引用
        sb2.delete(8, sb2.length()).insert(0, a);
        System.out.println(sb2);

        // public StringBuffer reverse()
        // 用于将字符序列逆序，返回修改后的该StringBuffer对象引用
        System.out.println(sb2.reverse());

        // 还有很多和String类里面含义和用法类似的一些API

    }
}
