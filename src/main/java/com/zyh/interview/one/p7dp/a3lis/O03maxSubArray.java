package com.zyh.interview.one.p7dp.a3lis;

/**
 * @description: 53. 最大子数组和
 * @author：zhanyh
 * @date: 2023/8/29
 */
public class O03maxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for(int i = 1; i < n; i ++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++)
            res = Math.max(res, dp[i]);
        return res;
    }
}
