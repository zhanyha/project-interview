package com.zyh.interview.juc;

/**
 * @description: 0~100奇偶依次打印
 * @author：zhanyh
 * @date: 2023/7/3
 */
public class OddEvenPrintBest {

    static final Object lock = new Object();

    public static void main(String[] args) {
        TurnRunnable turnRunnable = new TurnRunnable();
        new Thread(turnRunnable,"偶数线程").start();
        new Thread(turnRunnable,"奇数线程").start();
    }
    static class TurnRunnable implements Runnable{
        int num = 0;

        @Override
        public void run() {

            while (num <= 100){
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "打印：" + num++);
                    lock.notify();
                    try {
                        if(num <= 100)
                            lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }
}
