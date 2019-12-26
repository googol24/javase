package com.googol24.java.collection;

import java.util.*;

/**
 * 容器：java api提供的一系列类的实例，用于在程序中存放对象(数组也是一种特殊的容器，一般容器的动态存储比数组更方便)
 * 容器主要包括 Collection 和 Map 两种，Collection 存储着对象的集合，而 Map 存储着键值对（两个对象）的映射表。
 *
 *      -> Collection接口 - 定义了存取一组对象的方法，其子接口Set和List分别定义了自己的存储方式
 *          -> Set中的数据对象没有顺序且不可以重复（两个对象a,b重复的判定标准为a.equals(b)）
 *              -> 常见的Set有HashSet、TreeSet等
 *
 *          -> List中的数据对象有顺序且可以重复
 *              -> 常见的List有LinkedList、ArrayList等
 *
 *      -> Map接口 - 定义了存储”键值映射对“的方法
 *            -> 其实现类有HashMap、TreeMap等
 *
 *  容器类对象在调用remove、contains 等方法时需要比较对象是否相等（重复），这会涉及到对象类型的
 *  equals 方法和 hashCode 方法；
 *  对于自定义的(引用)类型，需要重写equals方法和hashCode方法以实现自定义对象的相等规则（重写equals方法必须重写hashCode方法）
 *
 *  hashCode()返回对象的散列码，是为了更好地支持基于哈希机制的Java集合类，例如HashTable HashMap HashSet等，一般对象作为键值/索引时会用到它
 *  为啥重写equals的时候必须重写hashCode?
 *  因为有一个规则：如果两个对象equals，那么它们的hashCode也一定相同。也即不存在两个hashCode不同的对象是equals的
 *
 *
 */
public class TestCollection {
    public static void main(String args[]) {
        Name name1 = new Name("Alice", "Kafka");
        Name name2 = new Name("Bob", "Steven");
        Name name3 = new Name("Cook", "Tim");

        // 父类引用指向子类对象
        // 这样写的好处：调用Collection接口的通用方法，无论c指向那个具体容器类型的实例，提供了最大的灵活性
        Collection c = new ArrayList();

        // 只能添加Object，不能添加基础数据类型(如 int)，因为基础数据类型是存放在栈空间里，随时有可能被清空
        c.add("hello");
        c.add(name1);
        c.add(new Integer(100));

        System.out.println(c.size());
        System.out.println(c);

        /*
        动态绑定到 ArrayList 类的toString()方法
        public String toString() {
            Iterator<E> it = iterator();
            if (! it.hasNext())
                return "[]";

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (;;) {
                E e = it.next();
                sb.append(e == this ? "(this Collection)" : e);
                if (! it.hasNext())
                    return sb.append(']').toString();
                sb.append(',').append(' ');
            }
        }
        */

        Collection c2 = new HashSet();
        c2.add("hello");
        c2.add(name2);
        c2.add(new Integer(100));
        System.out.println(c2);

        // 会去除hello元素，因为会在c2中遍历有没有和"hello"字符串equals的元素，有则去除
        c2.remove("hello");
        System.out.println(c2);

        // 会去除100这个元素，因为Integer类重写了equals()方法以及hashCode()方法
        c2.remove(new Integer(100));
        System.out.println(c2);

        // 如果Name类没有重写equals()以及hashCode()两个自定义对象相等规则的方法，则不会去除该元素
        System.out.println(c2.remove(new Name("Bob", "Steven")));
        System.out.println(c2);
    }
}

class Name {
    private String firstName, lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            return this.firstName.equals(((Name) obj).firstName) && this.lastName.equals(((Name) obj).lastName);
        }

        return super.equals(obj);// return false
    }

    @Override
    public int hashCode() {
        // String类重写了hashCode(),两个相等的字符串，它们的hashCode相等
        return this.firstName.hashCode();
    }
}
