package com.googol24.java.io;

import java.io.*;

/**
 * 缓冲相关的字符流（处理流）
 *
 * 缓冲流需要“套接”在相应的节点流之上，对读写的数据提供了缓冲的功能，显著减少了对于文件系统的读写次数，提高了读写的效率
 */
public class TestBufferedIO {
    public static void main(String[] args) {
        try {
            // BufferedInputStream BufferedOutputStream
            FileInputStream fis = new FileInputStream("D:\\Projects\\Java\\javase\\src\\com\\googol24\\java\\io\\TestBufferedIO.java");
            BufferedInputStream bis = new BufferedInputStream(fis);

            int c = 0;
            System.out.println(bis.read());
            System.out.println(bis.read());

            bis.mark(100);// 标记位置

            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char)c + " ");
            }
            System.out.println();

            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char)c + " ");
            }

            bis.reset();// 回到标记的位置

            System.out.println();
            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char)c + " ");
            }

            bis.close();

            // BufferedReader BufferedWriter
            String file = "mydir1" + File.separator + "mydir2" + File.separator + "random.txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            BufferedReader br = new BufferedReader(new FileReader(file));

            String s = null;

            for (int i = 0; i <= 100; i++) {
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();
            }

            bw.flush();

            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
