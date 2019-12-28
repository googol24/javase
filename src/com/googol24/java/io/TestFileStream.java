package com.googol24.java.io;

import java.io.*;

/**
 * 文件相关的字节流
 */
public class TestFileStream {
    public static void main(String[] args) {
        int b = 0;
        FileInputStream in = null;

        try {
            in = new FileInputStream("D:\\Projects\\Java\\javase\\src\\com\\googol24\\java\\io\\TestFileStream.java");
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件");
            System.exit(-1);
        }

        try {
            long number = 0;

            // 按照字节读取全部文件
            while ((b = in.read()) != -1) {
                // 把一个字节强制转换成字符
                System.out.print((char)b);
                number++;
            }

            in.close();

            System.out.println();

            System.out.println("共读取了" + number + "个字节");
        } catch (IOException e) {
            System.out.println("文件读取错误：" + e.getMessage());
            System.exit(-1);
        }


        int bit = 0;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream("D:\\Projects\\Java\\javase\\src\\com\\googol24\\java\\io\\TestFileStream.java");

            // 文件不存在时会自动创建
            fout = new FileOutputStream("mydir1" + File.separator + "mydir2" + File.separator + "copy2.txt");

            while ((bit = fin.read()) != -1) {
                fout.write(bit);
            }

            System.out.println("文件已复制！");

        } catch (FileNotFoundException e) {
            System.out.println("找不到文件！error: " + e.getMessage());
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("文件复制异常！error: " + e.getMessage());
            System.exit(-1);
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println("关闭输入输出流异常！error:" + e.getMessage());
                System.exit(-1);
            }
        }
    }
}
