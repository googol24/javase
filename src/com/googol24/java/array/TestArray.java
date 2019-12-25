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
 *
 * 二维数组：可以看成以数组为元素的数组
 * -> Java中多维数组的声明和初始化应该按照从高维到低维的顺序进行
 * -> 声明数组的时候不需要指定维数，只需要在初始化的时候指定即可
 *
 * 数组的拷贝
 * -> 使用java.lang.System类的静态方法 arraycopy，拷贝做的是赋值操作（注意区分引用类型和值类型）
 * -> public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 * -> 如果源数据数目超过目标数组的边界会抛出异常IndexOutOfBoundException
 *
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

        // 多维数组
        // 第一维为3，第二维未指定（可以为任意数）
        int[][] a2 = new int[3][];
        a2[0] = new int[2];
        a2[1] = new int[4];
        a2[2] = new int[3];

        int[][] a3 = {{1, 2}, {3, 5, 9, 4}, {7, 7, 5}};

        // 第一维为3，第二维为5，相当于3*5的表格
        int[][] a4 = new int[3][5];

        for (int i = 0; i < a3.length; i++) {
            for (int j = 0; j < a3[i].length; j++) {
                System.out.print("a3[" + i + "][" + j + "] = " + a3[i][j] + ", ");
            }
            System.out.println();
        }

        // arrayCopy
        String[] strArr = {"Microsoft", "IBM", "Sun", "Oracle", "apple"};
        String[] strArrBak = new String[6];
        System.arraycopy(strArr, 0, strArrBak, 0, s.length);
        for (String s1 : strArrBak) {
            System.out.print(s1 + " ");
        }
        System.out.println();

        int[][] intArr = {{1, 2}, {3, 6, 9, 8}, {5, 0, 4}};
        int[][] intArrBak = new int[3][];
        System.arraycopy(intArr, 0, intArrBak, 0, intArr.length);
        for (int[] arr : intArrBak) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // 修改了目标数组的引用，原数组也会被修改
        intArrBak[2][1] = 100;

        for (int[] arr : intArr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
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

    // 当前对象和date对象作比较
    int compare(Date date) {
        if (this.year > date.year) {
            return 1;
        } else if (this.year < date.year) {
            return -1;
        } else if (this.month > date.month) {
            return 1;
        } else if (this.month < date.month) {
            return -1;
        } else if (this.day > date.day) {
            return 1;
        } else if (this.day < date.day) {
            return -1;
        }

        return 0;
    }
}
