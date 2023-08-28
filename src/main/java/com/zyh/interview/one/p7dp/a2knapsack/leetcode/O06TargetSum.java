package com.zyh.interview.one.p7dp.a2knapsack.leetcode;

/**
 * @description: 494. 目标和
 * @author：zhanyh
 * @date: 2023/8/27
 */
public class O06TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0;  i < nums.length; i ++)
            sum += nums[i];

        if(target > sum || target < -sum)
            return 0;

        int[][] dp = new int[nums.length][2 * sum + 1]; // sum ~ 0
        for(int i = 0; i < 2 * sum  + 1; i ++){
            if(nums[0] == Math.abs(i - sum))
                dp[0][i] = 1;
            if(nums[0] == 0)
                dp[0][sum] = 2;
        }

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < 2 * sum + 1; j ++){//[-sum, sum]
                if(j + nums[i] < 2*sum + 1)
                    dp[i][j] += dp[i - 1][j + nums[i]];
                if(j - nums[i] >= 0)
                    dp[i][j] += dp[i - 1][j - nums[i]];
            }
        }
        return dp[nums.length - 1][target + sum];
    }
}
