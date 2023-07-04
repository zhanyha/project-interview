package com.zyh.interview.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/16
 */
public class Main {

    static class Student{
        private int age;
    }

    public static void  main(String[] args) {
        Student s1 = new Student();
        s1.age = 19;
        foo(s1);
        System.out.println(s1.age);
    }

    private static void foo(Student s1) {
        s1 = new Student();
        s1.age = 20;
        System.out.println(s1);
    }
}
