package com.googol24.java.wrapper;

/**
 * 基础数据类型的包装类
 *
 * 基础数据类型在程序运行过程中是在栈空间分配内存的，可以把基础数据类型包装成包装类，在堆空间分配内存
 * 基础数据类型的包装类封装了一个基本数据类型的值，并且为其提供了一系列操作
 *      byte    -> Byte
 *      short   -> Short
 *      int     -> Integer
 *      long    -> Long
 *      float   -> Float
 *      double  -> Double
 *      char    -> Character
 *      boolean -> Boolean
 */
public class TestWrapper {
    public static void main(String[] args) {
        Integer i = new Integer(100);
        Double d = new Double("123.456");// new Double(123.456)

        int j = i.intValue() + d.intValue();
        float f = i.floatValue() + d.floatValue();
        System.out.println(j);System.out.println(f);

        double pi = Double.parseDouble("3.1415926");
        double r = Double.valueOf("2.0").doubleValue();
        double s = pi * r * r;
        System.out.println(s);

        try {
            int k = Integer.parseInt("1.25");
        } catch (NumberFormatException e) {
            System.out.println("数据格式不对！");
        }

        System.out.println(Integer.toBinaryString(123) + "B");
        System.out.println(Integer.toOctalString(123) + "O");
        System.out.println(Integer.toHexString(123) + "H");

        String str = "1,2;3,4,5;6,7,8";
        double[][] res = parseStrToDoubleArray(str);

        // 打印二维数组
        for (double[] d1 : res) {
            for (double d2 : d1) {
                System.out.print(d2 + " ");
            }
            System.out.println();
        }
    }

    private static double[][] parseStrToDoubleArray(String str) {
        String[] tempStr1 = str.split(";");

        double[][] d = new double[tempStr1.length][];

        for (int i = 0; i < tempStr1.length; i++) {
            String[] tempStr2 = tempStr1[i].split(",");
            d[i] = new double[tempStr2.length];
            for (int j = 0; j < tempStr2.length; j++) {
                d[i][j] = Double.parseDouble(tempStr2[j]);
//                d[i][j] = new Double(tempStr2[j]).doubleValue();
            }
        }

        return d;
    }
}
