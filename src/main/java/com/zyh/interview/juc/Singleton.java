package com.zyh.interview.juc;

/**
 * @description: 双重检查的单例模式
 * @author：zhanyh
 * @date: 2023/7/3
 */
public class Singleton {

    private volatile static Singleton INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

}
