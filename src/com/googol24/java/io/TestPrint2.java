package com.googol24.java.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Print流
 *
 * 测试demo2
 */
public class TestPrint2 {
    public static void main(String[] args) {
        String fileName = args[0];

        if (fileName != null) {
            list(fileName, System.out);
        }
    }

    private static void list(String file, PrintStream ps) {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(file)
            );

            // 注意：该项目的classpath位于javase目录

            String s = null;

            while ((s = br.readLine()) != null) {
                ps.println(s);
            }

            br.close();

        } catch (IOException e) {
            ps.println("无法读取文件");
        }
    }
}
