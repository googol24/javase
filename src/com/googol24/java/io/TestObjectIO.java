package com.googol24.java.io;

import java.io.*;

/**
 * Object流：属于一种处理流，用于直接将Object写入或者读出，避免了把对象的各个成员各自分别输入或者输出的麻烦
 *
 * 也即序列化：把一个对象转换成字节流可以进行IO的数据
 *
 * transient关键字与Serializable接口
 *      -> 一旦成员变量被transient修饰，该成员变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问（访问的话只会给出默认值）。
 *      -> transient关键字只能修饰变量，而不能修饰方法和类。注意，变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 *      -> 一个静态变量不管是否被transient修饰，均不能被序列化
 *
 * Externalizable 接口：用于控制对象的序列化方式
 *      需要自己控制对象序列化的过程时，需要通过writeExternal和readExternal方法自己控制对象的序列化方式
 *      注意Serializable接口的序列化方式是由JDK来实现的
 *
 */
public class TestObjectIO {
    public static void main(String args[]) {
        T t = new T();
        t.k = 8;

        String fileName = "mydir1" + File.separator + "mydir2" + File.separator + "object.dat";

        try {
            // 把对象t写入文件
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.flush();
            oos.close();

            // 从文件读取对象
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fileName)
            );

            // 读取的对象需要强制转换为T类的对象
            T tReaded = (T)ois.readObject();
            System.out.println("输出读取的对象：");
            System.out.println(
                    "t.i:" + tReaded.i + ",t.j:" + tReaded.j + "t.d:" + tReaded.d + ",t.k:" + tReaded.k + ",t.m:" + tReaded.m
            );
            ois.close();

            // 自定义序列化规则
            String fileName2 = "mydir1" + File.separator + "mydir2" + File.separator + "object2.dat";
            ObjectOutputStream oos2 = new ObjectOutputStream(
                    new FileOutputStream(fileName2)
            );
            Person p = new Person("小明", 25);
            oos2.writeObject(p);

            ObjectInputStream ois2 = new ObjectInputStream(
                    new FileInputStream(fileName2)
            );
            Person pRead = (Person) ois2.readObject();
            // 输出读取到的对象
            System.out.println(pRead);

        } catch (IOException e) {
            System.out.println("IO异常：" + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("未找到指定类：" + e.getMessage());
            e.printStackTrace();
        }

    }
}

/**
 * T类实现Serializable接口
 * 使得T 类的对象可以对其进行序列化
 * 相当于打一个标记，使得编译器知道T类可以被序列化
 */
class T implements Serializable//, Externalizable
{
    int i = 10;
    int j = 9;
    double d = 2.3;
    int k = 15;
    // transient修饰的成员变量，在序列化的时候不予考虑
    // 也即该成员变量是短暂的（非持久）
    transient int m = 100;

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//
//    }
}

class Person implements Externalizable
{
    public Person() {
        System.out.println("无参数的构造器");
    }

    public Person(String name,int age) {
        System.out.println("带参数的构造器");
        this.name=name;
        this.age=age;
    }

    private String name;
    private int age;

    @Override
    public String toString() {
        return "姓名：" + this.name + "，年龄：" + this.age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name=(String)in.readObject();
        this.age=(int)in.readObject();
    }
}
