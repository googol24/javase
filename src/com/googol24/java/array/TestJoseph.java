package com.googol24.java.array;

/**
 * 约瑟夫环问题
 * 500 3
 */
public class TestJoseph {
    public static void main(String[] args) {

        // 位置数组
        boolean[] array = new boolean[500];
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }

        // 剩余的人数
        int leftCount = array.length;

        // 初始化计数器
        int countNumber = 0;

        // 初始化位置索引
        int index = 0;

        while (leftCount > 1) {
            if (array[index]) {
                countNumber++;
                if (countNumber == 3) {
                    countNumber = 0;
                    leftCount--;
                    array[index] = false;
                }
            }

            index = (index + 1) % array.length;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                System.out.println("最后一个人的位置：" + i);
            }
        }
    }
}
