package com.zyh.interview.algorithm.p7dp.a1basic;

/**
 * @description: 198. 打家劫舍
 * @author：zhanyh
 * @date: 2023/5/4
 */
public class C09HouseRobberDP {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            memo[i] = Math.max(memo[i + 1],  nums[i] + (i + 2 < n ? memo[i + 2] : 0));
        }
        return memo[0];
    }

    public static void main(String[] args) {
        System.out.println(new C09HouseRobberDP().rob(new int[]{1, 2, 3, 1}));
    }
}
