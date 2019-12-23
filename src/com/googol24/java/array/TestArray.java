package com.googol24.java.array;

/**
 * 数组：多个相同类型的数据的集合
 * -> 数组变量属于引用类型，数组也可以看成是对象，数组中的每个元素相当于是该对象的成员变量
 * -> 数组中的元素可以是任何数据类型，包括基本类型和引用类型
 *
 * 数组的声明:
 * -> 一维数组：type var[] 或者 type[] var
 * -> Java语言中声明数组时不能指定其长度（数组元素的个数），例如 int a[5] 是非法的
 * 数组的创建：
 * -> Java使用关键字new创建数组对象 声明数组名 = new 数组元素类型[数组元素个数]，如 int[] s = new int[5];
 * 数组的初始化：
 * -> 动态初始化：数组定义与为数组元素分配空间和赋值的操作分开进行
 * -> 静态初始化：在定义数组的同时就为数组元素分配空间并赋值
 * -> 默认初始化：数组是引用类型，它的元素相当于类的成员变量，因此数组空间分配后，每个元素也被按照成员变量的规则被隐式初始化（引用类型的默认值为null）
 * 数组元素的引用：
 * -> 引用方式：arrayName[index]，index也可以为表达式，index取值范围为0 ~ arrayName.length-1
 * -> 数组对象的 length 属性的值为数组的长度（元素个数）
 */
public class TestArray {
    public static void main(String[] args) {
        int[] s;// s 是在栈空间分配的一个数组类型的引用变量，默认为null（还没有初始化）
        s = new int[5];

        for (int i = 0; i < s.length; i++) {
            s[i] = i;
        }

        Date[] days;
        days = new Date[3];// days指向的堆内存里面的每一个元素都默认初始化为null
        for (int i = 0; i < days.length; i++) {
            days[i] = new Date(2019, 4, i + 1);
        }

        // 数组打印
        for (Date date : days) {
            System.out.println(date);
        }

        // 数组动态初始化
        int a[];
        a = new int[3];
        a[0] = 3; a[1] = 9; a[2] = 8;

        Date[] dates;
        dates = new Date[3];
        dates[0] = new Date(2019, 3, 6);
        dates[1] = new Date(2020, 4, 5);
        dates[2] = new Date(2019, 12, 24);

        // 数组静态初始化
        int[] b = {3, 9, 8}; // 相当于int[] b = new int[3];b[0]=3,b[1]=9;b[2]=8;
        Date[] dates2 = {
                new Date(2008, 3, 5),
                new Date(2017, 3, 5),
                new Date(2017, 4, 17)
        };

        int[] c = new int[5];
        Date[] dates3 = new Date[3];
        System.out.println("c[3]:" + c[3]);
        System.out.println("date3[2]:" + dates3[2]);
    }
}

class Date {
    private int year, month, day;

    Date(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    @Override
    public String toString() {
        return this.year + "-" + this.month + "-" + this.day;
    }
}
