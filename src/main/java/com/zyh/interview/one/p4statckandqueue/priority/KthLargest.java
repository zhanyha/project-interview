package com.zyh.interview.one.p4statckandqueue.priority;

import java.util.PriorityQueue;

/**
 * @description: 703. 数据流中的第 K 大元素
 * @author：zhanyh
 * @date: 2023/7/27
 */
public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int size;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < size) {
            queue.add(val);
        } else {
            int peek = queue.peek();
            if (peek < val) {
                queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }
}
