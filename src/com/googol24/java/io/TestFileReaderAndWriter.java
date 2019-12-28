package com.googol24.java.io;

import java.io.*;

/**
 * 文件相关的字符流
 */
public class TestFileReaderAndWriter {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;

        int ch = 0;

        try {
            fr = new FileReader("D:\\Projects\\Java\\javase\\src\\com\\googol24\\java\\io\\TestFileReaderAndWriter.java");
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
            System.exit(-101);
        } catch (IOException e) {
            System.out.println("文件读取异常！");
            System.exit(-102);
        }

        try {
            fw = new FileWriter("mydir1" + File.separator + "mydir2" + File.separator + "unicode.bat");
            for (int i = 0; i < 50000; i++) {
                fw.write(i);
            }

            fw.flush();
        } catch (IOException e) {
            System.out.println("文件写入异常！");
            System.exit(-103);
        }
    }
}
