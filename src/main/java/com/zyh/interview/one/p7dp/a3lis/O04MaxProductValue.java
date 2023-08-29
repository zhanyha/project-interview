package com.zyh.interview.one.p7dp.a3lis;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/29
 */
public class O04MaxProductValue {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for(int i = 1; i < n; i ++){
            if(nums[i] > 0){
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            }
            else{
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }

        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++){
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
