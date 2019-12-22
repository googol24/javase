package com.googol24.java.oo;

/**
 * Object类
 * 是所有Java类的根基类
 * 如果在类的声明中没有使用extends指明其基类，则默认其基类为Object
 */
public class TestObject { // 等价于public class TestObject extends Object
    public static void main(String[] args) {
//        Object o = new Object();System.out.println(o.getClass());System.out.println(o.toString());
        Dog d = new Dog();
        System.out.println(d);//System.out.println(d.toString());
        System.out.println("d:=" + d);
        Dog d2 = new Dog();
        System.out.println(d2);

        // equals : 判断对象是否相等的方法
        // equals方法必须具有自反性、传递性、对称性以及持久性
        // Object类中，当且仅当两个引用非空且指向同一个对象的时候，才会返回true，即 x.equals(y) <=> x == y
        Cat c1 = new Cat(1, 2, 3);
        Cat c2 = new Cat(1, 2, 3);
        Cat c3 = new Cat(1, 2, 4);
        System.out.println(c1 == c2);// 比较的是两个对象的内存地址是否相等
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));

        String s1 = "hello";
        String s2 = "hello";
//        s1 = new String("hello");
//        s2 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

class Dog {
    @Override
    public String toString() {
        return "I am a Dog";
    }
}

class Cat {
    int color;
    int height, weight;

    public Cat(int color, int height, int weight) {
        this.color = color;
        this.height = height;
        this.weight = weight;
    }


    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            if (obj instanceof Cat) {
//                return (this.color == ((Cat) obj).color && this.height == ((Cat) obj).height && this.weight == ((Cat) obj).weight);
                Cat c = (Cat)obj;
                return  (this.color == c.color && this.height == c.height && this.weight == c.weight);
            } else {
                return false;
            }
        }
    }
}