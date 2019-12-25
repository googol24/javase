package com.googol24.java.string;

public class Practice {
    public static void main(String[] args) {
        String s = "AVBDSsujdb_99sahzSzdYusdbSA--!122@ jswd";

        int lowerCount = 0, upperCount = 0, otherCount = 0;

        // 方法一
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (c >= 'a' && c <= 'z') {
//                lowerCount++;
//            } else if (c >= 'A' && c <= 'Z') {
//                upperCount++;
//            } else {
//                otherCount++;
//            }
//        }

        // 方法二
        String sL = "abcdefghijklmnopqrstuvwxyz";
        String sU = sL.toUpperCase();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (sL.indexOf(c) != -1) {
                lowerCount++;
            } else if (sU.indexOf(c) != -1) {
                upperCount++;
            } else {
                otherCount++;
            }
        }


        System.out.println(lowerCount);
        System.out.println(upperCount);
        System.out.println(otherCount);

        // 输出一个字符串中指定字符串出现的次数
        s = "hello javajava ha java i am study java thinking in java";
        System.out.println(getCountOfStr(s, "java"));

    }

    private static int getCountOfStr(String s, String regex) {
        int result = 0;

        // 方法一：数学计算法
//        String sn = s.replace(regex, "");
//        result = (s.length() - sn.length()) / regex.length();

        // 方法二：截取法
        int index = -1;
        while (s.indexOf(regex) != -1) { // 也可以用 s.contains(regex);
            index = s.indexOf(regex);
            result++;
            s = s.substring(index + regex.length());
        }

        return result;
    }
}
