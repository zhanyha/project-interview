package com.zyh.interview.one.p7dp;

/**
 * @description: 打家劫舍
 * @author：zhanyh
 * @date: 2023/7/23
 */
//  https://leetcode.cn/problems/house-robber-ii/
public class T01TryRobII {

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        int n = nums.length;
        int res1 = tryRob(nums, memo, n);
        int res2 = tryRob(nums, memo, n - 1);
        return Math.max(res1, res2);
    }

    private static int tryRob(int[] nums, int[] memo, int n) {
        memo[n - 1] = nums[n - 1];
        int end = (n == memo.length ? 1 : 0);
        for (int i = n - 2; i >= end; i--) {
            memo[i] = Math.max(memo[i + 1], nums[i] + (i + 2 >= n ? 0 : memo[i + 2]));
        }
        return n == memo.length ? memo[1] : memo[0];
    }
}
