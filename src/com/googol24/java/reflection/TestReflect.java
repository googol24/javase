package com.googol24.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Java反射的使用
 *
 *  反射机制：是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
 *  对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。
 *      -> 站在ClassLoader的角度来看，被加载进内存里面的一个个class可以看成是一个个class对象
 *      -> 进一步细化，每一个class对象里面的一个个属性或者方法也可以看成一个个对象
 *      -> java.lang.Class 代表了加载到内存里面的Class对象，Object类的getClass()方法可以拿到该类对象（等同于类名.class）
 *      -> Class类的getClassLoader 可以拿到装载这个Class的ClassLoader
 *      -> java.lang.reflect 包里定义了各个元数据的类，例如方法Method 属性Field等
 *
 *  与Java反射相关的类如下：

        类名	                用途
        Class类	            代表类的实体，在运行的Java应用程序中表示类和接口
        Field类	            代表类的成员变量（成员变量也称为类的属性）
        Method类	            代表类的方法
        Constructor类	    代表类的构造方法
 *
 *
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
        // 根据类名获取类的对象
        String packageName = TestReflect.class.getPackage().getName();
        String classStr = packageName + ".T";
        Class c = Class.forName(classStr);

        // 实例化类
        Object instance = c.newInstance();

        // 获取类的方法
        Method[] methods = c.getMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
            if (method.getName().equals("m1")) {
                method.invoke(instance);
            } else if (method.getName().equals("m2")) {
                method.invoke(instance, 100, 200);
                Class returnType = method.getReturnType();
                System.out.println(returnType.getName());
                Class[] paramTypes = method.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.println(paramType.getName());
                }
            }
        }

    }
}

class T {
    static {
        System.out.println("T类被加载");
    }

    T () {
        System.out.println("T 的构造方法被调用");
    }

    int i;

    String s;

    public void setI (int i){
        this.i = i;
    }

    public String getS() {
        return this.s;
    }

    public void m1() {
        System.out.println("T.m1()被调用！");
    }

    public void m2(int i, int j) {
        System.out.println("T.m2()被调用，传了两个参数 i=" + i + ", j=" + j);
    }
}
