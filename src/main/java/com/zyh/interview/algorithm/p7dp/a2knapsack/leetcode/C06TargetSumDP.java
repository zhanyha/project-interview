package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

import java.util.Arrays;

/**
 * @description: 494. 目标和
 * @author：zhanyh
 * @date: 2023/5/11
 */
public class C06TargetSumDP {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        int total = 0;
        for (int i = 0; i < n; i++)
            total += nums[i];
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int j = 0; j < 2 * total + 1; j++) {
            if(j == target)
                memo[nums.length -1][j] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 2 * total + 1; j++) {
                if(j - nums[i] >= 0 && j - nums[i] < 2 * total + 1)
                    memo[i][j] += memo[i][j - nums[i]];
                if(j + nums[i] >= 0 && j + nums[i] < 2 * total + 1)
                    memo[i][j] += memo[i][j + nums[i]];
            }
        }
        return memo[nums.length - 1][target];
    }

    public static void main(String[] args) {
        System.out.println(new C06TargetSumDP().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
