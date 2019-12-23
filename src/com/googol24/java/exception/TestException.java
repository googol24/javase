package com.googol24.java.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 异常：Java 程序运行期出现的错误。Java提供了一套处理异常的机制
 *
 *      -> 注意：javac 编译期出现的错误（语法错误等）不属于异常
 *      -> 看一个异常主要看异常类型以及异常出现的位置（程序的行号）
 *      -> Java程序执行过程中如果出现异常事件，可以生产一个异常类对象，该异常对象封装了异常事件的信息并将被提交给Java运行时系统，这个过程称为“抛出异常”
 *      -> Java运行时系统接收到异常对象时，会寻找能处理这一异常的代码并把当前异常对象交给其处理，这一过程称为“捕获异常”
 *
 * 异常分类：
 *      Throwable 是所有异常类的根基类
 *      Error 类和 Exception 类是 Throwable 的直接子类
 *          -> Error：称为错误，也叫系统错误（程序处理不了的错误），由JVM生成并抛出，包括动态链接失败、虚拟机错误等
 *          -> Exception：异常（程序可以处理的错误），所有异常类的父类，其子类对应了各种各样的异常事件，一般需要用户显式的声明或者捕获
 *              -> RuntimeException : 运行时异常(可以被捕获，也可以可以不被catch)，其产生比较频繁，处理也麻烦，
 *                                    如果显示声明或者捕获将会影响到程序可读性和系统效率，系统自动捕获并将它们交给缺省的异常处理程序（用户可不必对其处理）
 *              -> 其他的Exception: 必须被catch的 Exception
 *
 *      try {
 *          可能出现异常的代码
 *      } catch (SomeException1 e) {
 *          异常1处理逻辑（注意：异常1不能是异常2的基类，否则会导致异常2捕获不到）
 *      } catch (SomeException2 e) {
 *          异常2处理逻辑
 *      }......
 *      finally {
 *          统一的出口，统一收尾处理逻辑（一般来做资源清除的工作：如关闭连接、关闭打开的文件、删除临时文件等）
 *          最终无论如何一定会执行的语句
 *      }
 *
 *  自定义异常：可以自定义自己的异常，继承Exception类或者RuntimeException类等
 *  异常方法重写：异常类方法重写时，重写方法需要抛出与原方法索抛出的异常类型一致或者不抛出异常
 *
 */
public class TestException {
    public static void main(String[] args){
//        int[] arr = {1, 2, 3};
//        System.out.println(arr[2]);

        System.out.println("1 异常基本概念......");
        // try 块里面包括了可能会出现异常的语句
        // catch 里面是针对捕获到的不同类型异常的相应异常处理逻辑
        //  -> catch 的时候应该注意捕获的顺序，如果先捕获了父类异常，再捕获其子类异常会导致捕获不到了
        // 一个try可以跟好几个catch分别处理不同类型的异常
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);// 数组长度越界的异常
        } catch (ArrayIndexOutOfBoundsException e) { // 异常产生时，系统会生产并初始化一个异常对象传过来，该对象被程序命名为e
//            throw e;
            System.out.println("array index is out of bounds!");
//            e.printStackTrace();// 打印错误的堆栈信息
        } finally {
            System.out.println("finish");
        }

        System.out.println();
        System.out.println("2 异常分类......");
        TestException te = new TestException();
        //te.m(0); // 可以不去捕获RuntimeException
        try {
            te.m(0);// 也可以捕获RuntimeException
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        FileInputStream in  = null;
        try {
            in = new FileInputStream("mytxt.txt");// 可能会抛出FileNotFoundException，属于非运行时的Exception，必须手动捕获

            int b;
            b = in.read();// 可能会抛出IOException，属于非运行时的Exception，必须手动捕获

            while (b != -1) {
                System.out.println((char)b);
                b = in.read();
            }
        } catch (FileNotFoundException fe) {
//            fe.printStackTrace();
            System.out.println(fe.getMessage());
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException | NullPointerException e) {
//                e.printStackTrace();
                System.out.println("关闭失败！error:" + e.getMessage());
            }
        }

        System.out.println();
        System.out.println("3 声明方法抛出的异常......");
        // 方法抛出的异常，可以由上级程序（使用该方法的程序）处理，上级如果不处理，也需要直接抛出
        try {
            te.f();
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("程序出错：文件未找到");
        } catch (IOException e) {
            System.out.println("程序IO出错：" + e.getMessage());
        } finally {
            System.out.println("处理完成");
        }

        System.out.println();
        System.out.println("4 使用自定义的异常......");
        te.manager();
    }

    public void m(int i) throws ArithmeticException { // ArithmeticException 继承自 RuntimeException
        if (i == 0) {
            throw new ArithmeticException("除数不能为零！");
        }
    }

    // 方法抛出的异常，可以由上级程序（使用该方法的程序）处理
    public void f() throws FileNotFoundException, IOException{
        FileInputStream in = new FileInputStream("mytxt.txt");// 可能会抛出FileNotFoundException，属于非运行时的Exception，必须手动捕获

        int b;
        b = in.read();// 可能会抛出IOException，属于非运行时的Exception，必须手动捕获

        while (b != -1) {
            System.out.println((char)b);
            b = in.read();
        }
    }

    public void regist(int num) throws MyException{
        if (num < 0) {
            throw new MyException("人数为负数，不合理", 3);
        }

        System.out.println("登记人数：" + num);
    }

    public void manager() {
        try {
//            this.regist(100);
            this.regist(-2);
        } catch (MyException e) {
            System.out.println("登记失败，出错类型码：" + e.getId() + "，出错原因：" + e.getMessage());
        }
    }
}

class MyException extends Exception {
    private int id;

    public MyException(String message, int id) {
        super(message);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
