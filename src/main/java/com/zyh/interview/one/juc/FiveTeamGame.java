package com.zyh.interview.one.juc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: 王者荣耀5个人都加载完成才开始游戏，用java应该怎么实现的（java的并发编程）
 * @author：zhanyh
 * @date: 2023/8/16
 */
public class FiveTeamGame {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println(" 游戏开始");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new GameTask(i, cyclicBarrier)).start();
        }
    }

    static class GameTask implements Runnable{
        int threadId;
        CyclicBarrier cyclicBarrier;

        public GameTask(int threadId, CyclicBarrier cyclicBarrier) {
            this.threadId = threadId;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((long) (Math.random() * 5000)); // 很重要
                System.out.println(threadId + " 准备...");
                cyclicBarrier.await();
                System.out.println(threadId + " 全军出击...");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// 1. aqs
// 2. hash冲突有几种解决办法， 在哪里应用了
// 3. mq顺序性，消费者
// 4. kafka为什么快? kafka的性能模型
// 5. https tsl握手细节
// 6. 红黑树的旋转
// 7. 临键锁能否解决幻读?
