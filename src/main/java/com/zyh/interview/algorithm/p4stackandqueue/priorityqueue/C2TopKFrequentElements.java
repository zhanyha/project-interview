package com.zyh.interview.algorithm.p4stackandqueue.priorityqueue;

import java.util.*;

/**
 * @description: 前 K 个高频元素
 * @author：zhanyh
 * @date: 2023/4/18
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 1 <= nums.length <= 10^5
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 */
public class C2TopKFrequentElements {
    class Node{
        int freq;
        int val;

        public Node(int freq, int val) {
            this.freq = freq;
            this.val = val;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
        }
        Set<Integer> keys = map.keySet();
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o2.freq - o1.freq);
        for (Integer key : keys) {
            Integer val = map.get(key);
            queue.add(new Node(val, key));
        }
        List<Integer> res = new ArrayList<>();
        while (k > 0 && !queue.isEmpty()) {
            res.add(queue.poll().val);
            k--;
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] ints = new C2TopKFrequentElements().topKFrequent(nums, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
