package com.googol24.java.io;

import java.io.*;

/**
 * 流 Stream
 *
 * 在Java程序中，对于数据的输入输出操作以“流”的方式进行。J2SDK提供了各种各样的“流”类，用以获取不同的数据
 * 程序中，通过标准的方法输入或者输出数据
 *
 * java.io包里面定义了多个流类型（类或者抽象类）来实现输入/输出功能，可从不同的角度对其进行分类
 *      -> 按照数据流的方向不同可以分为输入流和输出流（输入：文件->程序；输出：程序->文件）
 *      -> 按照数据处理单位的不同可以分为字节流和字符流（字节：010101...按照字节(8 bit)读）
 *              -> 字节流按照一个一个字节进行读写，字符流按照一个一个字符进行读写
 *      -> 按照功能的不同可以分为节点流和处理流
 *              -> 节点流可以从一个特定的数据源（节点）读写数据（例如文件、内存）
 *              -> 处理流是“连接”在已存在的流（节点流或者处理流）之上，通过对数据的处理为程序提供更为强大的读写功能的流
 *
 * J2SDK 所提供的所有流类型均位于包java.io内，均继承自以下四种抽象流类型之一
 *                  字节流（以Stream结尾）             字符流
 *      输入流         InputStream                  Reader
 *      输出流         OutputStream                 Writer
 *
 *      InputStream
 *          继承自InputStream的流都是用于向程序中输入数据，且数据的单位为字节(8 bit)
 *
 *          常见的InputStream API
 *          ->  读取一个字节并以整数的形式返回（0~255，也即00000000~11111111）。如果返回-1表示已经到达输入流的末尾
 *              int read() throws IOException
 *          -> 读取一系列字节并存储到一个字符数组buffer，返回实际读取的字节数。如果读取前已到输入流的末尾则返回-1
 *              int read(byte[] buffer) throws IOException
 *          -> 读取length个字节，并存储到一个字节数组buffer，从offset位置开始，返回实际读取的字节数，如果读取前已到输入流的末尾则返回-1
 *              int read(byte[] buffer, int offset, int length) throws IOException
 *          -> 关闭流释放内存资源
 *              void close() throws IOException
 *          -> 跳过n个字节不读，返回实际跳过的字节数
 *              int skip(long n) throws IOException
 *
 *      OutputStream
 *          继承自OutputStream的流都是用于程序中输入数据，且数据的单位为字节(8 bit)
 *
 *          常见的OutputStream API
 *          -> 向输入流中写入一个字节数据，该字节数据为参数b的低8位
 *              void write(int b) throws IOException
 *          -> 将一个字节类型的数组中的数据写入输入流
 *              void write(byte[] b) throws IOException
 *          -> 将一个字节类型的数组从指定位置offset开始的length个字节长度的数据写入到输入流
 *              void write(byte[] b, int offset, int length) throws IOException
 *          -> 关闭流释放内存资源
 *              void close() throws IOException
 *          -> 将输出流中缓冲的数据全部写出的目的地（注意：关闭输出流之前最好执行下flush()）
 *              void flush() throws IOException
 *
 *      Reader
 *          继承自Reader的流都是用于向程序中输入数据，且数据的单位为字符（16 bit）
 *
 *          常见的Reader API 与InputStream类似
 *
 *      Writer
 *          继承自Writer的流都是用于程序中输入数据，且数据的单位为字符（16 bit）
 *
 *          常见的Writer API 与OutputStream类似
 *          -> 将一个字符串中的字符写入到输出流，实际上调用了String类的toCharArray()把String转换为char[]
 *              void write(String string) throws IOException
 *
 *  常见的节点流
 *
 *      类型                      字符流                                 字节流
 *      File（文件）        FileReader/FileWriter               FileInputStream/FileOutputStream
 *      Memory Array      CharArrayReader/CharArrayWriter     ByteArrayInputStream/ByteArrayOutputStream
 *      Memory String     StringReader/StringWriter
 *      Pipe（管道）        PipedReader/PipedWriter             PipedInputStream/PipedOutputStream
 *
 *  常见的处理流
 *
 *      类型                      字符流                                 字节流
 *  Buffering（缓冲）       BufferedReader/BufferWriter        BufferInputStream/BufferedOutputStream
 *  Filtering               FilterReader/FilterWriter        FilterInputStream/FilterOutPutStream
 *  字符字节之间的转换    InputStreamReader/OutputStreamWriter
 *  对象序列化                                                 ObjectInputStream/ObjectOutputStream
 *  Data Conversion                                          DataInputStream/DataOutputStream
 *  Counting                 LineNumberReader                LineNumberInputStream
 *  Peeking ahead            PushBackReader                  PushBackInputStream
 *  Printing                 PrintWriter                     PrintStream
 */
public class TestIO {

}
