package com.zyh.interview.juc;

/**
 * @description: 0~100奇偶依次打印
 * @author：zhanyh
 * @date: 2023/7/3
 */
public class OddEvenPrint {
    static int num = 0;
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new OddThread(), "偶数线程").start();
        Thread.sleep(10);
        new Thread(new EvenThread(), "奇数线程").start();
    }

    static class OddThread implements Runnable {
        @Override
        public void run() {
            while (num <= 100) {
                synchronized (lock) {
                    if ((num & 1) == 0)
                        System.out.println(Thread.currentThread().getName() + "打印： "+ num++);
                }
            }
        }
    }

    static class EvenThread implements Runnable {

        @Override
        public void run() {
            while (num <= 100) {
                synchronized (lock) {
                    if ((num & 1) == 1)
                        System.out.println(Thread.currentThread().getName() + "打印： "+num++);
                }
            }
        }
    }
}
