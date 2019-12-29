package com.googol24.java.io;

import java.io.*;

/**
 * 转换流：属于处理流，可以把字节流转换成字符流
 *
 * InputStreamReader和OutputStreamWriter用于字节数据到字符数据的转换
 *      -> InputStreamReader需要和InputStream“套接”
 *      -> OutputStreamWriter需要和OutputStream“套接”
 *      -> 转换流在构造的时候可以指定其编码集合 InputStreamReader isr = new InputStreamReader(System.in, "ISO8859-1");
 *      -> 注意：之前说的Buffered字节流只能套接在字节流之上，Buffered字符流只能套接在字符流之上
 *
 */
public class TestTransformIO {
    public static void main(String[] args) {
        try {
            // OutputStreamWriter
            String file = "mydir1" + File.separator + "mydir2" + File.separator + "char.txt";
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream(file)
            );
            osw.write("Microsoft");
            System.out.println(osw.getEncoding());
            osw.close();

            osw = new OutputStreamWriter(
                    // FileOutputStream指定为追加写文件形式的输出流
                    new FileOutputStream(file, true)
            , "ISO8859-1");
            osw.write("Microsoft");
            System.out.println(osw.getEncoding());
            osw.close();

            // InputStreamReader
            InputStreamReader isr = new InputStreamReader(
                    // System.in是标准的输入，readLine会阻塞
                    System.in
            );
            BufferedReader br = new BufferedReader(isr);

            // 每次读取标准输入的一行
            String s = br.readLine();
            while (s != null) {
                if(s.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println(s.toUpperCase());
                s = br.readLine();
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
