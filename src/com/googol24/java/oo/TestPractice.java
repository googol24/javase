package com.googol24.java.oo;

interface PetCarer {
    public void feed();
    public void play();
}

class Worker implements PetCarer {
    @Override
    public void feed() {
        System.out.println("工人给宠物喂食");
    }

    @Override
    public void play() {
        System.out.println("工人和宠物玩");
    }
}

class Farmer implements PetCarer {
    @Override
    public void feed() {
        System.out.println("农民给宠物喂食");
    }

    @Override
    public void play() {
        System.out.println("农民和宠物玩");
    }
}

class Cadre implements PetCarer {
    @Override
    public void feed() {
        System.out.println("国家干部给宠物喂食");
    }

    @Override
    public void play() {
        System.out.println("国家干部和宠物玩");
    }
}

public class TestPractice {
    public static void main(String args[]) {
        Worker a = new Worker();
        Farmer b = new Farmer();
        Cadre c = new Cadre();

        f(a);
        f(b);
        f(c);
    }

    public static void f(PetCarer petCarer) {
        petCarer.feed();
        petCarer.play();
    }
}
