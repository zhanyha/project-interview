package com.zyh.interview.one.p7dp.a3lis;

import java.util.Arrays;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/28
 */
public class O02WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i ++)
            Arrays.fill(dp[i], 1);

        for(int i = 1; i < n; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[i] > nums[j])
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                else if(nums[i] < nums[j])
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res, dp[i][0]);
            res = Math.max(res, dp[i][1]);
        }

        return res;
    }
}
