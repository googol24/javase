package com.googol24.java.oo;

/**
 * 多态性，也叫动态绑定或者延迟绑定，是同一个行为具有多个不同表现形式或形态的能力。
 *
 * 在java程序的执行期间（而非程序编译期间）判断所引用对象的实际类型，根据其实际类型调用其实际方法
 *      -> 注意：和属性不一样的地方是，基类对象指向子类实例的引用时，是不可访问其子类的特有属性的
 * 存在多态的三个必要条件：（1）要有类的继承 （2）要有方法重写 （3）要有父类引用指向子类对象
 * 多态的优点：（1）消除类型之间的耦合关系 （2）可替换性 （3）可扩充性 （4）接口性 （5）灵活性 （6）简化性
 *
 */
public class TestPolymorphism {
    public static void main(String[] args) {
        MyCat c = new MyCat("cat_name", "blue");
        MyDog d = new MyDog("dog_name", "black");

        Lady l1 = new Lady("lady1", c);
        Lady l2 = new Lady("lady2", d);

        l1.myPetEnjoy();
        l2.myPetEnjoy();

        MyBird e = new MyBird();
        Lady l3 = new Lady("lady3", e);
        l3.myPetEnjoy();
    }
}

/**
 * abstract
 *
 * 用abstract关键字来修饰一个类时，这个类叫做抽象类；用abstract关键字来修饰一个方法时，这个方法叫抽象方法(相当于c++的虚函数)
 * 含有抽象方法的类必须被声明为抽象类，抽象类必须被继承，抽象方法必须被重写
 *      -> 可以在子类重写，或者子类的子类重写(此时子类也必须继承该抽象方法，因而子类也是抽象类)
 * 抽象类不能被实例化
 * 抽象方法只需声明，而无需实现
 */
//class MyAnimal { // 第一版
abstract class MyAnimal {// 第二版
    private String name;

    MyAnimal(String name) {
        this.name = name;
    }

    // 第一版
    /*public void enjoy() {
        System.out.println("叫声......");
    }*/

    // 抽象方法 第二版(enjoy方法由于其实际业务意义，只需要声明，没有实现的必要)
    public abstract void enjoy();
}

class MyCat extends MyAnimal {
    private String eyesColor;

    MyCat(String name, String eyesColor) {
        super(name);
        this.eyesColor = eyesColor;
    }

    @Override
    public void enjoy() {
        System.out.println("猫叫声......");
    }
}

class MyDog extends MyAnimal {
    private String furColor;

    MyDog(String name, String furColor) {
        super(name);
        this.furColor = furColor;
    }

    @Override
    public void enjoy() {
        System.out.println("狗叫声......");
    }
}

class MyBird extends MyAnimal {
    MyBird() {
        super("bird");
    }

    @Override
    public void enjoy() {
        System.out.println("鸟叫声......");
    }
}

class Lady {
    private String name;

    private MyAnimal pet;

    Lady(String name, MyAnimal animal) {
        this.name = name;
        this.pet = animal;
    }

    public void myPetEnjoy() {
        this.pet.enjoy();
    }
}