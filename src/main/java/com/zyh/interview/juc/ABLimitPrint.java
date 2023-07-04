package com.zyh.interview.juc;

/**
 * @description: 交替打印AB, 各打印50个，共计100个字符。
 * @author：zhanyh
 * @date: 2023/7/3
 */
public class ABLimitPrint {
    static final Object lock = new Object();

    public static void main(String[] args) {
        TurnRunnable turnRunnable = new TurnRunnable();
        new Thread(turnRunnable).start();
        new Thread(turnRunnable).start();
    }

    static class TurnRunnable implements Runnable {
        int total = 1;

        @Override
        public void run() {
            while (total <= 100) {
                synchronized (lock) {
                    if ((total & 1) == 1) {
                        System.out.println("A-" + total++);
                    } else {
                        System.out.println("B-" + total++);
                    }
                    lock.notify();

                    try {
                        if(total <= 100)
                            lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
