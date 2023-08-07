package com.zyh.interview.test;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class StaticTest extends Base{

    static {
        System.out.println("test static");
    }

    public StaticTest() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new StaticTest();
    }

}
class Base {

    static {
        System.out.println("base static");
    }

    public Base() {
        System.out.println("base constructor");
    }
}