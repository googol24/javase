package com.googol24.java.file;

import java.io.File;
import java.io.IOException;

/**
 * File 类
 *
 * java.io.File类代表系统的文件名（路径和文件名），可以用其增加、删除、查找某种类型的文件或者文件夹
 *
 * File类常见构造方法
 *      -> public File(String pathname) 以pathname为路径创建Rile对象（并非创建一个文件）
 *         如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储
 *      -> public File(String parent, String child) 以parent为父路径，child为子路径创建File对象
 *
 * File的静态属性String separator存储了当前系统的路径分隔符
 *      -> 跨平台的常量，在linux下为/，在windows下为\
 *
 */
public class TestFile {
    public static void main(String[] args) {
        String seperator = File.separator;
        String fileName = "myfile.txt";
        String directory = "mydir1" + seperator + "mydir2";//
//        String directory = "mydir1/mydir2";

        File f = new File(directory, fileName);

        if (f.exists()) {
            System.out.println("文件名：" + f.getAbsolutePath());
            System.out.println("文件大小：" + f.length());
        } else {
            f.getParentFile().mkdir();

            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
