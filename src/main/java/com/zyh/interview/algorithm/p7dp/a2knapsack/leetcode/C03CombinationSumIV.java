package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

import java.util.Arrays;

/**
 * @description: 377. 组合总和 Ⅳ
 * @author：zhanyh
 * @date: 2023/5/10
 */
public class C03CombinationSumIV {
    private int[] memo;
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0 || target == 0)
            return 0;
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return combinationSum4Core(nums, target);
    }

    private int combinationSum4Core(int[] nums, int target) {
        if(target == 0)
            return 1;
        if(target < 0)
            return 0;
        if(memo[target] != -1)
            return memo[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += combinationSum4Core(nums, target - nums[i]);
        }
        memo[target] = res;
        return memo[target];
    }

    public static void main(String[] args) {
        System.out.println(new C03CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
