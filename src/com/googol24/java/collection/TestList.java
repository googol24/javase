package com.googol24.java.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * List接口
 *
 * List接口是Collection的子接口，实现List接口的容器类中的元素是有顺序的，并且可以重复
 * List容器中的元素都对应一个整数型的序号记录其在容器中的位置，可以根据序号存取容器中的元素
 *      -> 有点类似于数组，但是List容器的大小是可以动态改变的
 * J2SDK提供的List容器类有ArrayList LinkedList等
 *      Object get(int index)
 *      Object set(int index, Object Element) 返回index位置原来的元素
 *      void add(int index, ObjectElement)
 *      Object remove(int index)
 *      int indexOf(Object o) // o元素出现在容器中的第一个位置
 *      int lastIndexOf(Object o) // o元素出现在容器中的最后一个位置
 *
 * List常用算法
 *  -> java.util.Collections类提供了一系列静态方法实现类基于List容器的一些常用算法
 *      void sort(list) 对list容器内的元素排序
 *      void shuffle(list) 对list容器内的对象进行随机排列
 *      void reverse(list) 对list容器内的对象进行逆序排列
 *      void fill(list, object) 用一个特定对象重写整个list容器
 *      void copy(List dest, List src) 将src List容器内容拷贝到dest List容器，此时需要保证dest容器里有src容器里所有元素的位置（desc容量>=src容器）
 *      int binarySearch(List, object) 对于顺序的list容器，采用折半查找的方法查找指定对象
 */
public class TestList {
    public static void main(String[] args) {
        List l1 = new LinkedList();
        for (int i = 0; i <= 5; i++) {
            l1.add("a" + i);
        }

        System.out.println(l1);

        l1.add(3, "a100");
        System.out.println(l1);

        l1.set(6, "a200");
        System.out.println(l1);

        System.out.print(l1.get(2) + " ");

        System.out.println(l1.indexOf("a3"));

        l1.remove(1);
        System.out.println(l1);

        // List常见算法
        List list1 = new LinkedList();
        List list2 = new LinkedList();

        for (int i = 0; i <= 9; i++) {
            list1.add("a" + i);
            list2.add("b" + i);
        }
        System.out.println(list1);

        Collections.shuffle(list1);
        System.out.println(list1);

        Collections.reverse(list1);
        System.out.println(list1);

        Collections.sort(list1);
        System.out.println(list1);

        System.out.println(Collections.binarySearch(list1, "a5"));

        System.out.println(list2);
        list2.add("b");list2.add("d");list2.add("c");
        Collections.copy(list2, list1);
        System.out.println(list2);
    }
}
