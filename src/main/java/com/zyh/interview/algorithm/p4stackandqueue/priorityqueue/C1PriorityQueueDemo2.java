package com.zyh.interview.algorithm.p4stackandqueue.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 使用PriorityQueue实现数字按个位数排序
 * @author：zhanyh
 * @date: 2023/4/18
 * 1. 调研PriorityQueue的API, 随机插入10个数字，并取出，看是最大堆还是最小堆
 */
public class C1PriorityQueueDemo2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 % 10 - o2 % 10;
            }
        });
        int[] nums = new int[]{51, 93, 66, 85, 14, 12};
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.print(poll + ",");
        }
    }
}
