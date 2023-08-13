package com.zyh.interview.one.p7dp.a1basic;

/**
 * @description: 198. 打家劫舍
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class O09HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[n];
        memo[0] = nums[0];

        for (int i = 1; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], nums[i] + (i - 2 >= 0 ? memo[i - 2] : 0));
        }

        return memo[n - 1];
    }
}
