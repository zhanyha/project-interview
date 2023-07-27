package com.zyh.interview.one.juc;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/22
 */
public class OddEvenPrint {

    public static void main(String[] args) throws InterruptedException {
        OddEvenTask oddEvenTask = new OddEvenTask();
        Thread t1 = new Thread(oddEvenTask, "t1");
        Thread t2 = new Thread(oddEvenTask, "t2");
        t1.start();
        Thread.sleep(10);
        t2.start();
    }

    static class OddEvenTask implements Runnable {
        int num = 1;
        final Object lock = new Object();

        @Override
        public void run() {
            synchronized (lock) {
                while (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + " " + num++);
                    lock.notify();
                    try {
                        if (num <= 100)
                            lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
