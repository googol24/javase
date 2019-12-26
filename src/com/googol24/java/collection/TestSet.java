package com.googol24.java.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Set接口
 *
 * Set接口是Collection的子接口，Set接口没有提供额外的方法，但是实现Set接口的容器类中的元素是没有顺序的，并且不能重复
 * Set容器可以与数学中的“集合”概念相对应
 * 常见的Set容器实现类有hashSet（用哈希表实现）、TreeSet（用树结构实现）等
 */
public class TestSet {
    // 防止JDK 1.5集合警告
//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Set<Object> s = new HashSet<Object>();

        s.add("hello");
        s.add(new Name("f1", "l1"));
        s.add("world");
        s.add(new Name("Alice", "Green"));
        s.add(new Integer(100));
        s.add(new Name("f1", "l1"));// 相同元素不会被加入，因为String和Name类均重写了equals()和hashCode()
        s.add("hello");// 相同元素不会被加入

        System.out.println(s);


        Set s1 = new HashSet();
        Set s2 = new HashSet();
        s1.add("a");s1.add("b");s1.add("c");
        s2.add("d");s2.add("a");s2.add("b");

        // 构造方法初始化容器对象
        Set sn = new HashSet(s1);
        sn.retainAll(s2);// 取交集
        Set su = new HashSet(s1);
        su.addAll(s2);

        System.out.println(sn);
        System.out.println(su);
    }
}
