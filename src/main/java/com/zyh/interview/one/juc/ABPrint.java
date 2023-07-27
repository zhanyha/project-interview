package com.zyh.interview.one.juc;

/**
 * @description: 交替打印100个AB, 先打印A
 * @author：zhanyh
 * @date: 2023/7/22
 */
public class ABPrint {

    public static void main(String[] args) throws InterruptedException {
        PrintRunnable printRunnable = new PrintRunnable();
        Thread t1 = new Thread(printRunnable, "t1");
        Thread t2 = new Thread(printRunnable, "t2");
        t1.start();
        Thread.sleep(10);
        t2.start();
    }


   static class PrintRunnable implements Runnable{
        int count = 1;
        Object lock = new Object();
        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 100) {
                    String threadName = Thread.currentThread().getName();
                    if((count & 1) == 1)
                        System.out.println(threadName + " A");
                    else{
                        System.out.println(threadName + " B");
                    }
                    count++;
                    lock.notify();
                    try {
                        if(count <= 100)
                            lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
