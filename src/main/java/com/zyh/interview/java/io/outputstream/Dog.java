package com.zyh.interview.java.io.outputstream;

import java.io.Serializable;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/13
 */
public class Dog implements Serializable {
    private String name;
    private String color;

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
