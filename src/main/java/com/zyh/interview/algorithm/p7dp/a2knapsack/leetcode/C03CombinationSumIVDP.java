package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

/**
 * @description: 377. 组合总和 Ⅳ
 * @author：zhanyh
 * @date: 2023/5/10
 */
public class C03CombinationSumIVDP {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0 || target == 0)
            return 0;
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0)
                    memo[i] += memo[i - nums[j]];
            }
        }
        return memo[target];
    }

    public static void main(String[] args) {
        System.out.println(new C03CombinationSumIVDP().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
