package com.zyh.interview.one.p4statckandqueue.priority;

import java.util.*;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/27
 */
// https://leetcode.cn/problems/top-k-frequent-elements/

public class O01TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> o1.key - o2.key);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (queue.size() < k)
                queue.add(new Pair(entry.getValue(), entry.getKey()));
            else {
                Pair peek = queue.peek();
                if (peek != null && peek.key < entry.getValue()) {
                    queue.poll();
                    queue.add(new Pair(entry.getValue(), entry.getKey()));
                }
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()){
            ans[i++] = queue.poll().value;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new O01TopKFrequent().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 1)));
    }
    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
