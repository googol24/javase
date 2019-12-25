package com.googol24.java.file;

import java.io.File;

/**
 * 递归目录读取程序
 */
public class TestFileDirectory {
    public static void main(String[] args) {
        File file = new File("D:/A");

        // 打印根目录
        System.out.println(file.getName());

        listTree(file, 1);
    }

    // 递归目录树
    private static void listTree(File f, int level) {
        File[] children = f.listFiles();

        // 前导字符串
        StringBuffer prefix = new StringBuffer();
        for (int i = 0; i < level; i++) {
            prefix.append("    ");
        }

        for (File child : children) {
            System.out.println(prefix + child.getName());
            if (child.isDirectory()) {
                listTree(child, level + 1);
            }
        }
    }
}
