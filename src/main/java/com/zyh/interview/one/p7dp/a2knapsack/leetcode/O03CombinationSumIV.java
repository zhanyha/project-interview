package com.zyh.interview.one.p7dp.a2knapsack.leetcode;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/26
 */
public class O03CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for( int i = 1; i <= target ; i ++){
            for(int j = 0; j < nums.length; j ++){
                if(i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
