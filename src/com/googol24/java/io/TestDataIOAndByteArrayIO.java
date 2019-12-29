package com.googol24.java.io;

import java.io.*;

/**
 * 数据流
 * DataInputStream和DataOutputStream分别继承自InputStream和OutputStream，属于处理流，
 * 需要分别套接在InputStream和OutputStream类型的节点流上
 *
 * DataInputStream和DataOutputStream提供了可以存取机器无关的Java原始数据类型（如int double long boolean等）的方法
 *
 * 构造方法：
 *      DataInputStream(InputStream in)
 *      DataOutputStream(OutputStream out)
 *
 * 注意：在学习数据流之前，如果需要写一个long类型的数据进入文件，我们需要先把long类型的数据转换成字符串才能写入字符流，
 * 把long类型的数据转换成字符串再转换成字节数组(byte[])才能写入字节流，这样比较麻烦
 *
 */
public class TestDataIOAndByteArrayIO {
    public static void main(String[] args){
        // 声明一个指向内存里一个字节数组(byte[])空间的输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // 声明一个套接了baos的DataOutputStream
        DataOutputStream dos = new DataOutputStream(baos);

        try {
            // 向内存写入一共8 byte的一个double类型数据
            dos.writeDouble(Math.random());
            // 向内存写入一共1 byte的boolean类型数据
            dos.writeBoolean(true);
            // 向内存写入了一共8个字节的long类型的数据
            dos.writeLong(12586542);

            // 把baos里指定的字节数组作为ByteArrayInputStream的构造参数
            // 创建一个指向该字节数组的输入流
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

            System.out.println(bais.available());// bais可以读取的字节空间大小

            // 声明一个套接了bais的DataInputStream
            DataInputStream dis = new DataInputStream(bais);

            // 必须按照写入的指定顺序进行读取不同数据
            System.out.println(dis.readDouble()); // 读出8字节，转换成double数据输出
            System.out.println(dis.readBoolean()); // 再读出1字节，转换成boolean数据输出
            System.out.println(dis.readLong()); // 再读出8字节，转换成long数据输出

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
