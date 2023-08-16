package com.zyh.interview.one.p7dp.a2knapsack.leetcode;

import java.util.Arrays;

/**
 * @description: 416. 分割等和子集
 * @author：zhanyh
 * @date: 2023/8/15
 */
public class O01PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int num : nums) sum += num;
        if((sum & 1) != 0) return false;
        int C = sum / 2;
        boolean[] memo = new boolean[C + 1];
        for(int i = 0; i < C + 1; i ++){
            memo[i] = i == nums[0];
        }

        for(int i = 1; i < nums.length; i ++){
            for(int j = C; j >= nums[i] ; j --){
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }

        return memo[C];
    }
}
