package com.googol24.java.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Iterator 接口：容器的迭代器
 * 由于Collection接口的实现有多种多样，因而不同的容器的底层遍历方式也不一样，用Iterator可以统一所有类型容器的遍历操作
 *
 * -> 所有实现了Collection接口的容器类都有（重写了）一个iterator方法用以返回一个实现了Iterator接口的对象
 *      -> Iterator<E> iterator();
 * -> Iterator对象称作迭代器，用以方便地实现对容器内元素的遍历操作（可以理解为一个游标），容器对象的iterator()默认指向容器第一个元素的左边
 * -> Iterator接口定义了如下方法：
 *      -> boolean hasNext(); 判断游标右边是否有元素
 *      -> Object next(); 返回游标右边的元素并将游标移动到下一个位置
 *      -> void move(); 删除游标左边的元素，在执行完next()操作后该操作只能执行一次
 *          -> Iterator对象的remove()方法是在迭代过程中删除元素的唯一的安全方法，如果使用容器对象的remove()方法可能会产生异常
 */
public class TestIterator {
    public static void main(String[] args) {
        Collection c = new HashSet();
        c.add(new Name("san", "zhang"));
        c.add(new Name("si", "li"));
        c.add(new Name("wu", "wang"));

        // 取出容器对象的迭代器
        Iterator iterator = c.iterator();

        while (iterator.hasNext()) {
//            Object name = iterator.next();
//            System.out.println(name);

            Name name = (Name) iterator.next();
            // 打印顺序不一定和add的顺序相同，因为Set是无序的
            System.out.println(name.getFirstName());
        }


        // 测试remove
        for (Iterator i = c.iterator(); i.hasNext(); ) {
            Name n = (Name)i.next();

            if (n.getFirstName().length() > 2) {
                i.remove();// 这里如果换成c.remove(n);会产生异常ConcurrentModificationException，
                            // 因为iterator在遍历容器的时候会进行锁定，除了iterator对象之外其他对象不能对其进行remove
//                c.remove(n);
            }
        }

        System.out.println(c);
    }
}
