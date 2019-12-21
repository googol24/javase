package com.googol24.java.oo;

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return "Name: " + this.getName() + ", Age: " + this.getAge();
    }
}

class Student extends Person {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String getInfo() {
        return "Name: " + this.getName() + ", Age: " + this.getAge() + ", School: " + this.getSchool();
    }
}

public class TestPerson {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("john");
        student.setAge(18);
        student.setSchool("Peking University");

        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getSchool());
    }
}
