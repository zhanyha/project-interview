package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

/**
 * @description: 416. 分割等和子集
 * @author：zhanyh
 * @date: 2023/5/10
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */
public class C01PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if ((sum & 1) != 0)
            return false;

        boolean[] memo = new boolean[sum / 2 + 1];
        for (int i = 0; i < memo.length; i++) {
            if (i == nums[0])
                memo[i] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum / 2; j - nums[i] >= 0 && j >= j - nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[memo.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new C01PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5}));
    }
}
