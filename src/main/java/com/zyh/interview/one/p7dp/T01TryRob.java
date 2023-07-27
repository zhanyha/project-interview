package com.zyh.interview.one.p7dp;

import java.util.Arrays;

/**
 * @description: 打家劫舍
 * @author：zhanyh
 * @date: 2023/7/23
 */
//  https://leetcode.cn/problems/house-robber/
public class T01TryRob {


    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        int n = nums.length;
        memo[n - 1] = nums[n - 1];
        for (int i = memo.length - 2; i >= 0; i--) {
            memo[i] = Math.max(memo[i + 1], nums[i] + (i + 2 >= n ? 0 : memo[i + 2]));
        }
        return memo[0];
    }
}
