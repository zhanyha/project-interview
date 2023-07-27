package com.zyh.interview.one.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/21
 */
public class TestAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int a = 0;
        for (int i = 0; i < 20000; i++) {
            atomicInteger.getAndIncrement();
            a++;
        }
        System.out.println(atomicInteger);
        System.out.println(a);
    }
}
