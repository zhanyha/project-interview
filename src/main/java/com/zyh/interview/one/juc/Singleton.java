package com.zyh.interview.one.juc;

/**
 * @description: 双重检查单例
 * @author：zhanyh
 * @date: 2023/7/21
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        Thread
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance != null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
