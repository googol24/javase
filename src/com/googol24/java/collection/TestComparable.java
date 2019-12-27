package com.googol24.java.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Comparable接口
 *
 *  所有可以“排序”（也即可以比较大小）的类都实现了 java.lang.Comparable 接口，Comparable接口中只有一个方法：
 *      public int compareTo(Object obj)
 *           -> 返回0 : 表示 this == obj
 *           -> 返回正数 : 表示 this > obj
 *           -> 返回负数 : 表示 this < obj
 *
 *  实现了Comparable接口的类通过实现compareTo方法从而确定该类对象的排序方式
 *
 */
public class TestComparable {
    public static void main(String[] args) {
        List list = new LinkedList();

        list.add(new MyName("Cook", "Tim"));
        list.add(new MyName("Candy", "Steven"));
        list.add(new MyName("Alice", "Kafka"));
        list.add(new MyName("Bob", "Steven"));

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

        // Comparable接口支持泛型
        System.out.println("使用泛型：");
        List<MyNameGeneric> genericList = new LinkedList<>();
        genericList.add(new MyNameGeneric("Cook", "Tim"));
        genericList.add(new MyNameGeneric("Candy", "Steven"));
        genericList.add(new MyNameGeneric("Alice", "Kafka"));
        genericList.add(new MyNameGeneric("Bob", "Steven"));

        System.out.println(genericList);

        Collections.sort(genericList);

        System.out.println(genericList);
    }
}

class MyName implements Comparable {
    private String firstName, lastName;

    public MyName(String firstName, String lastName) {
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
    public int compareTo(Object o) {
        MyName n = (MyName) o;

        // 借助了String类的compareTo方法，先按照姓排列，姓相同的再按照名字排列
        int lastComp = this.lastName.compareTo(n.lastName);

        return lastComp != 0 ? lastComp : this.firstName.compareTo(n.firstName);

        /* String类的排序规则
        public int compareTo(String anotherString) {
            int len1 = value.length;
            int len2 = anotherString.value.length;
            int lim = Math.min(len1, len2);
            char v1[] = value;
            char v2[] = anotherString.value;

            int k = 0;
            while (k < lim) {
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
            return len1 - len2;
        }
        */
    }
}

class MyNameGeneric implements Comparable<MyNameGeneric> {
    private String firstName, lastName;

    public MyNameGeneric(String firstName, String lastName) {
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
    public int compareTo(MyNameGeneric obj) {

        // 借助了String类的compareTo方法，先按照姓排列，姓相同的再按照名字排列
        int lastComp = this.lastName.compareTo(obj.lastName);

        return lastComp != 0 ? lastComp : this.firstName.compareTo(obj.firstName);
    }
}
