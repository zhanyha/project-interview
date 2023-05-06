package com.zyh.interview.algorithm.p7dp.a1basic;

/**
 * @description: 打家劫舍 II
 * @author：zhanyh
 * @date: 2023/5/4
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class C10HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            memo[i] = Math.max(memo[i + 1],  nums[i] + (i + 2 < n ? memo[i + 2] : 0));
        }
        return memo[0];
    }
}
