package com.googol24.java.oo;

class People {

    private String name;

    private String location;

    People(String name) {
        this.name = name;
        location = "Beijing";
    }

    People(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String info() {
        return "Name: " + this.name + ", Location: " + this.location;
    }
}

class Stu extends People {
    private String school;

    Stu(String name, String school) {
        this(name, "Beijing", school);
    }

    Stu(String name, String location, String school) {
        super(name, location);
        this.school = school;
    }

    @Override
    public String info() {
        return super.info() + ", School: " + this.school;
    }
}

class Teacher extends People {
    private String capital;

    Teacher(String name, String capital) {
        this(name, "Beijing", capital);
    }

    Teacher(String n, String l, String c) {
        super(n, l);
        this.capital = c;
    }

    @Override
    public String info() {
        return super.info() + ", Capital:" + this.capital;
    }
}

public class Practice2 {

    public static void main(String args[]) {
        People p1 = new People("A");
        People p2 = new People("B", "Shanghai");

        Stu s1 = new Stu("C", "Peking University");
        Stu s2 = new Stu("D", "Guangzhou", "Jinan University");

        System.out.println(p1.info());
        System.out.println(p2.info());
        System.out.println(s1.info());
        System.out.println(s2.info());

        Teacher t1 = new Teacher("E", "Professor");
        System.out.println(t1.info());
    }
}
