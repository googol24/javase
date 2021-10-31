package com.googol24.java.string;

/**
 * String类：java.lang.String代表不可变的字符序列
 *
 * "xxx"为String类的一个对象
 */
public class TestString {
    public static void main(String[] args) {
        // 字符串常量，分配在data segment
        String s1 = "hello", s2 = "world", s3 = "hello";// 编译器优化，s3赋值的时候发现数据区的"hello"串已经存在了，直接指向s1指向的字符串
        System.out.println(s1 == s3);// true s1和s3不是new出来的

        s1 = new String("hello");
        s2 = new String("hello");
        System.out.println(s1 == s2);// false s1和s2是new出来的，指向不同的内存数据区空间
        System.out.println(s1.equals(s2));// String类重写了equals方法

        // 字符数组
        char c[] = {'s', 'u', 'n', ' ', 'j', 'a', 'v', 'a'};
        // 用字符数组构造字符串
        String s4 = new String(c);
        // 用字符数组截取构造字符串
        String s5 = new String(c, 4, 4);
        System.out.println(s4);
        System.out.println(s5);


        // 字符串类常见API
        s1 = "sun java";
        s2 = "Sun Java";
        // 返回字符串中第index个位置的字符：public char charAt(int index)
        System.out.println(s1.charAt(4));

        // 返回字符串的长度（包含的字符数）：public int length()
        System.out.println(s2.length());

        // 返回字符串中出现str的第一个位置：public int indexOf(String str)
        System.out.println(s1.indexOf("java"));
        System.out.println(s1.indexOf("Java"));// s1中没有字符串"Java"，返回-1

        // 返回字符串中从fromIndex开始，出现str的第一个位置：public int indexOf(String str, int fromIndex)

        // 比较当前字符串与s是否一样（忽略大小写）：public boolean equalsIgnoreCase(String s)
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        // 在字符串中用newChar字符替换oldChar字符：public String replace(char oldChar, char newChar)
        String s = "我是程序员，我在学Java";
        System.out.println(s.replace('我', '你'));

        // 判断字符串是否以prefix字符串开头：public boolean startsWith(String prefix)
        s = "Welcome to Java World!";
        s1 = "    Sun Java    Oracle ";
        System.out.println(s.startsWith("Welcome"));

        // 判断字符串是否以suffix字符串结尾：public boolean endsWith(String suffix)
        System.out.println(s.endsWith("World"));

        // 返回一个字符串为该字符串的大写/小写形式：public String toUpperCase() / public String toLowerCase()
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());

        // 截取字符串的字串，从beginIndex位置开始：public String substring(int beginIndex)
        System.out.println(s.substring(11));

        // 截取字符串的字串，从beginIndex位置开始(包括beginIndex)到endIndex位置结尾(不包括endIndex)：public String substring(int beginIndex, int endIndex)
        System.out.println(s.substring(12, 13));

        // 返回将该字符串去掉开头和结尾空格后的字符串
        System.out.println(s1.trim());

        // 将基本数据类型转换为字符串：public static String valueOf(基本数据类型 x)，属于String类的静态重载方法
        // 注意：引用类型也可以转换成字符串，public static String valueOf(Object obj)，调用的是obj的toString方法
        double d = 12.34;
        String dStr = String.valueOf(d);
        System.out.println("字符串" + dStr + "是" + dStr.length() + "位数");

        Date date = new Date(2018, 10, 24);
        System.out.println(String.valueOf(date));// 动态绑定（多态） 执行到 date.toString()
        /*
        public static String valueOf(Object obj) {
            return (obj == null) ? "null" : obj.toString();
        }
        */

        // 将一个字符串按照指定的分隔符regex分隔，返回分隔后的字符串数组：public String[] split(String regex)
        s = "Mary,F,1976";
        String[] sArr = s.split(",");
        for (String si : sArr) {
            System.out.print(si + " ");
        }
        System.out.println();

        // 字符串折叠测试
        String str1 = "1234";
        String str2 = new String("1234");
        String str3 = "12" + "34"; // 字符串折叠
        System.out.println("str1 == str2 ? " + (str1 == str2));
        System.out.println("str1.equals(str2) ? " + (str1.equals(str2)));
        System.out.println("str1 == str3 ? " + (str1 == str3));
        System.out.println("str1.equals(str3) ? " + str1.equals(str3));
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
