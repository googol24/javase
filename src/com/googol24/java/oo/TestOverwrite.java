package com.googol24.java.oo;

/**
 * 方法的重写
 * 在子类中可以根据需要对从基类中继承来的方法进行重写
 * 重写方法必须和被重写方法具有相同的方法名称、参数列表和返回类型
 * 重写方法不能使用比被重写方法更严格的访问权限
 *
 * 注意区分!!重载：一个类中具有相同返回类型和方法名，但是参数类型或者参数个数不同的多个的方法
 */
public class TestOverwrite {
    public static void main(String args[]) {
        Person person = new Person();

        person.setAge(34);
        person.setName("Alice");

        Student student = new Student();
        student.setAge(23);
        student.setName("Smith");
        student.setSchool("University of Cambridge");

        System.out.println(person.getInfo());
        System.out.println(student.getInfo());
    }
}
