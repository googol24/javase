package com.googol24.java.io;

import java.io.*;
import java.util.Date;

/**
 * Print流
 *
 * demo3
 */
public class TestPrint3 {
    public static void main(String[] args) {
        String s= null;

        String logFile = "mydir1" + File.separator + "mydir2" + File.separator + "log.log";

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(logFile, true));

            while ((s = br.readLine()) != null) {
                if (s.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println(s.toUpperCase());

                // 记录文件日志
                pw.println("--------------------------------");
                pw.println(s.toUpperCase());
            }

            pw.println("--------------------------------");
            pw.println(new Date());

            // 可有可无
            pw.flush();

            pw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
