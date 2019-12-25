package com.googol24.java.collection;

import java.util.*;

/**
 * 容器：java api提供的一系列类的实例，用于在程序中存放对象(容器的动态存储比数组更方便)
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
}
