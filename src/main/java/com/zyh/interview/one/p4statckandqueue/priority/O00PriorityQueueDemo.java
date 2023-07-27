package com.zyh.interview.one.p4statckandqueue.priority;

import java.util.*;

/**
 * @description: API 测试
 * @author：zhanyh
 * @date: 2023/7/27
 */

public class O00PriorityQueueDemo {
    public void test(){
        int[] nums = new int[]{1,2,3,4,5,6};
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        for (int num : nums) {
            queue.add(num);
        }
        System.out.println(queue);
    }

    public static void main(String[] args) {
        new O00PriorityQueueDemo().test();
    }
}
