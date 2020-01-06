package com.googol24.java.network;

import java.io.*;
import java.net.*;

/**
 * 测试一个HTTP协议的请求
 */
public class TestHttp {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);

            PrintWriter printWriter = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );

            printWriter.println("GET / HTTP/1.1");
            printWriter.println("Host: localhost");
            printWriter.println("Content-type: text/html");
            printWriter.println();
            printWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String str = "";

            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }

            bufferedReader.close();
            printWriter.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("IO异常：" + e.getMessage());
        }
    }
}
