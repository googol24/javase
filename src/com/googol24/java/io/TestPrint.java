package com.googol24.java.io;

import java.io.*;

/**
 * Print 流
 *
 * PrintWriter和PrintStream都属于输出处理流，分别针对字符与字节
 * PrintWriter和PrintStream提供了重载的print println等方法用于多种数据类型的输出
 * PrintWriter和PrintStream的输出操作不会抛出异常
 * PrintWriter和PrintStream有自动flush功能（程序可以不用flush，也可以flush）
 */
public class TestPrint {
    public static void main(String[] args) {
        PrintStream ps = null;

        String file = "mydir1" + File.separator + "mydir2" + File.separator + "unicode.txt";

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ps = new PrintStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ps != null) {
            // 把系统输出由命令行切换为文件
            System.setOut(ps);
        }

        // 换行计数器
        int lnCount = 0;

        for (char c = 0; c < 60000; c++) {
            System.out.print(c + " ");

            if (lnCount++ >= 100) {
                System.out.println();
                lnCount = 0;
            }

        }
    }
}
