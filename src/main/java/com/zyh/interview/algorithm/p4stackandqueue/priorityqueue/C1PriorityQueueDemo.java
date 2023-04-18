package com.zyh.interview.algorithm.p4stackandqueue.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: PriorityQueue 的API使用
 * @author：zhanyh
 * @date: 2023/4/18
 * 1. 调研PriorityQueue的API, 随机插入10个数字，并取出，看是最大堆还是最小堆
 */
public class C1PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] nums = new int[]{1, 3, 6, 5, 4, 2};
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.print(poll + ",");
        }
    }
}
