package com.googol24.java.Enum;

/**
 * 枚举类型：用于做指定的取值范围限制
 *  -> 只能够取特定值中的一个
 *  -> 使用enum关键字
 *  -> 是java.lang.Enum类型
 */
public class TestEnum {
    // 定义了一个新的枚举类型MyColor，取值有red,green,blue三种
    public enum MyColor {
        red,
        green,
        blue
    }

    public static void main(String[] args) {
        MyColor color = MyColor.red;

        switch (color) {
            case red:
                System.out.println("red");
                break;
            case blue:
                System.out.println("blue");
                break;
            case green:
                System.out.println("green");
                break;
            default:
                System.out.println("default");
                break;
        }

        System.out.println(color);
    }
}
