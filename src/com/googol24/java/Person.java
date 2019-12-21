package com.googol24.java;

public class Person {

    private int id;

    private int age = 20;

    public int getAge() {
        return this.age;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(23);
        System.out.println("hello world");
    }
}
