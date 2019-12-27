package com.googol24.java.collection;

import java.util.*;

/**
 * 泛型（Generic Paradigm）
 * JDK 1.5 引入
 *
 *      JDK1.4以前类型不明确：
 *          装入集合的类型都被当作Object对待，从而失去自己的实际类型
 *          从集合中取出元素时往往需要转型，效率低，且容易产生错误（取出之后强制转换的时候易产生错误）
 *
 *      解决办法：
 *          在定义集合的时候同时定义集合中元素的类型 Collection<Type>，此时编译器会自动检查类型匹配
 *              -> 可以在定义Collection的时候指定
 *              -> 也可以在循环的时候用Iterator指定
 *
 *      好处：增强程序的可读性和稳定性
 *
 */
public class TestGeneric {
    public static void main(String[] args) {
        // 使用泛型定义一个只能存储String类型对象的List
        List<String> list = new LinkedList<String>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for (int i = 0; i < list.size(); i++) {
            // list.get(i)返回的就是泛型指定的类型
            System.out.println(list.get(i));
        }

        Collection<String> cs = new HashSet<String>();
        cs.add("a");cs.add("b");cs.add("c");

        Iterator<String> iterator = cs.iterator();
        while (iterator.hasNext()) {
            // iterator.next()直接取出String类型的元素
            System.out.println(iterator.next());

        }

        // foreach
        for (String s : cs) {
            System.out.println(s);
        }
    }
}
