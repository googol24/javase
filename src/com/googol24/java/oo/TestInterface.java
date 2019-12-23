package com.googol24.java.oo;
/**
 * 接口
 *
 * 接口是Java中的一种抽象类型，抽象方法和常量值的定义的集合
 * 从本质上讲，接口是一种特殊的抽象类，这种抽象类中只包含常量和方法的定义，而没有变量和方法实现。
 * -> 接口中的变量之所以定义成静态的常量（只属于该类的成员），是因为这样可以避免多继承的情况下出现父类成员变量命名冲突带来的一系列问题
 * -> 一个类通过继承接口的方式，从而来继承接口的抽象方法。
 * 接口的特性：
 * -> 接口可以多重实现（Java中类的继承只支持单继承，但是一个类可以实现多个接口）
 * -> 接口中声明的属性默认为public static final 的，也只能是public static final的
 * -> 接口中只能定义抽象方法，而且这些方法默认为public的，也只能为public的
 * -> 接口可以继承其他接口，并添加新的属性和抽象方法
 * -> 多个无关的类可以实现同一个接口（支持多重实现（也叫多继承）：一个类可以实现多个无关的接口，实现的多个接口用逗号隔开）
 * -> 与继承关系类似，接口与实现类之间也存在多态性
 * -> 一个Java类的语法格式：
 * <modifier> class <className> [extends <superClass>] [implements <interface> [,<interface>]*] {
 * <declaration>
 * }
 */
interface Singer {
    public void sing();

    public void sleep();
}

interface Painter {
    public void paint();

    public void eat();
}

class Stud implements Singer {
    private String name;

    Stud(String name) {
        this.name = name;
    }

    @Override
    public void sing() {
        System.out.println("student is singing");
    }

    @Override
    public void sleep() {
        System.out.println("student is sleeping");
    }

    public void study() {
        System.out.println("studying");
    }
}

class StuTeacher implements Singer, Painter {
    private String name;

    StuTeacher(String name) {
        this.name = name;
    }

    @Override
    public void sing() {
        System.out.println("teacher is singing");
    }

    @Override
    public void sleep() {
        System.out.println("teacher is sleeping");
    }

    @Override
    public void paint() {
        System.out.println("teacher is painting");
    }

    @Override
    public void eat() {
        System.out.println("teacher is eating");
    }

    public void teach() {
        System.out.println("teaching");
    }
}

public class TestInterface {
    public static void main(String[] args) {
        Singer s1 = new Stud("le");
        // 注意：s1作为Singer类型的引用，只能访问Stud的sing()和sleep()方法，以下同理
        s1.sing();s1.sleep();
//        s1.study();// compiled error

        Singer s2 = new StuTeacher("steven");
        s2.sing();s2.sleep();
//        s2.teach();s2.paint();s2.eat();// compiled error

        Painter p1 = (Painter) s2;
        p1.paint();p1.eat();

        // 多态测试
        System.out.println("test for polymorphism:");
        f(s1);
        f(s2);
    }

    public static void f(Singer s) {
        s.sing();
        s.sleep();
    }
}
