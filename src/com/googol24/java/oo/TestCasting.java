package com.googol24.java.oo;

/**
 * 对象转型（casting）
 *
 * 一个基类的引用类型变量可以“指向”其子类的对象(父类引用指向子类对象)
 *      -> 或者一个接口类型的变量可以“指向”其实现类的对象
 * 一个基类的引用不可以访问其子类对象新增加的成员（成员属性或者成员方法）
 * 可以使用 引用类型变量 instanceof 类名 来判断该引用类型变量所“指向”的对象是否属于该类或该类的子类
 * 子类的对象可以当做基类的对象来使用被称为“向上转型”（upcasting），反之成为“向下转型”(downcasting)，也叫强制转换
 */
public class TestCasting {
    public static void main(String[] args) {
        Animal animal = new Animal("name");
        Cat1 cat = new Cat1("cat", "black");
        Dog1 dog = new Dog1("dog", "white");

        /*
        System.out.println(animal instanceof Animal);//true
        System.out.println(cat instanceof Animal);//true
        System.out.println(dog instanceof Animal);//true
        System.out.println(animal instanceof Cat);//false
        */

        animal = new Dog1("bigyellow", "yellow");
        System.out.println(animal.name);
        //System.out.println(animal.furColor);// compiled error
        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Dog1);

        // 基类对象访问子类对象的新增成员时，需要将基类对象强制转换为子类对象的引用
        Dog1 dog1 = (Dog1)animal;
        System.out.println(dog1.furColor);

        // 对象转型的可扩展性（基类引用指向子类对象）
        Animal a = new Animal("name");
        Cat1 b = new Cat1("cat", "blue");
        Dog1 c = new Dog1("dog", "green");

        TestCasting tc = new TestCasting();
        tc.showAnimal(a);
        tc.showAnimal(b);
        tc.showAnimal(c);

    }

    // 一个方法搞定，无需根据参数类型写多个重载方法
    public void showAnimal(Animal animal) {
        System.out.println(animal.name);

        if (animal instanceof Cat1) {
            System.out.println(" " + ((Cat1) animal).eyeColor + " eyes");
        } else if (animal instanceof Dog1) {
            System.out.println(" " + ((Dog1) animal).furColor + " fur");
        }
    }
}

class Animal {
    public String name;

    Animal(String name) {
        this.name = name;
    }
}

class Cat1 extends Animal {
    public String eyeColor;

    Cat1(String n, String c) {
        super(n);
        this.eyeColor = c;
    }
}

class Dog1 extends Animal {
    public String furColor;

    Dog1(String n, String c) {
        super(n);
        this.furColor = c;
    }
}
