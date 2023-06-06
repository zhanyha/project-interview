package com.zyh.interview.leetcode.p7dp;

/**
 * @description:  最大子数组和
 * @author：zhanyh
 * @date: 2023/5/27
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class C02MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        memo[0] = nums[0];
        for (int i = 1; i < n; i++) {
            memo[i] = Math.max(nums[i] + memo[i - 1], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }
}
