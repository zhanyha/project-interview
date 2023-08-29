package com.zyh.interview.one.p7dp.a3lis;

import java.util.Arrays;

/**
 * @description: 300. 最长递增子序列
 * @author：zhanyh
 * @date: 2023/8/28
 */
public class O01LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i ++){
            for(int j = 0; j <= i - 1; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i ++){
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
