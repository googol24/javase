package com.googol24.java.reflection;

import sun.applet.AppletClassLoader;

/**
 * JDK 内置的ClassLoader
 * ClassLoader的具体作用就是将class文件加载到jvm中去，这样程序就可以正确运行了。
 * 但是，jvm启动的时候，并不会一次性加载所有的class文件，而是根据需要去动态加载
 *
 * BootStrap ClassLoader
 *      -> 属于最顶层的ClassLoader，用于加载JDK的核心类 核心的jar包rt.jar中的类
 *      -> 其他的class loader也是被该class loader加载进来
 *      -> 使用native language实现(c/c++)
 *
 * Extension ClassLoader
 *      -> 加载JDK的扩展类 JDK/jre/lib/ext 目录下面的类
 *      -> 使用Java实现
 *
 * Application ClassLoader
 *      -> 加载用户定义的类
 *      -> 属于系统的ClassLoader
 *      -> 使用Java实现
 *
 * 其他ClassLoader
 *      -> 可以查看JDK文档
 *
 * JDK ClassLoader的层次关系（非继承关系）
 *      -> ClassLoader的getParent()：获取某个classLoader的parent，也即上一层Loader（层级的parent，并非继承的parent）
 *      -> 加载过程：ClassLoader在加载类的时候首先会找上一层Loader是不是已经加载过了，如果已经load过了就不会再次load了（安全性好）
 */
public class TestClassLoader {
    public static void main(String[] args) {
        // String类位于tr.jar，它的classLoader是null，也即最核心的BootStrap ClassLoader
        System.out.println(String.class.getClassLoader());

        // JDK/jre/lib/ext 目录下面的类
        // ExtClassLoader负责加载
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());

        // 自己定义的类
        // AppClassLoader负责加载
        // AppClassLoader属于系统的ClassLoader
        System.out.println(TestClassLoader.class.getClassLoader().getClass().getName());

        // 获取系统的ClassLoader
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());

        // JDK ClassLoader的层级关系
        // 装载本类的class loader
        ClassLoader c = TestClassLoader.class.getClassLoader();
        System.out.println("ClassLoader的层级关系：");
        while (c != null) {
            // 打印层级
            System.out.println(c.getClass().getName());
            c = c.getParent();
        }
    }
}
