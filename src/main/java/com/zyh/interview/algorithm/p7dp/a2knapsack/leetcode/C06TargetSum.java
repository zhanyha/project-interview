package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

import java.util.Arrays;

/**
 * @description: 494. 目标和
 * @author：zhanyh
 * @date: 2023/5/11
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 */
public class C06TargetSum {
    private int[][] memo;
    private int total;
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        this.total = 0;
        for (int i = 0; i < nums.length; i++) {
            this.total += nums[i];
        }
        memo = new int[2 * total + 1][nums.length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return findTargetSumWaysCore(nums, target, 0, 0);
    }

    private int findTargetSumWaysCore(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if (target == sum)
                return 1;
            else
                return 0;
        }
        if (memo[sum + this.total][index] != -1)
            return memo[sum + this.total][index];
        int res = 0;
        res += findTargetSumWaysCore(nums, target, sum - nums[index], index + 1);
        res += findTargetSumWaysCore(nums, target, sum + nums[index], index + 1);
        memo[sum + this.total][index] = res;
        return memo[sum + this.total][index];
    }

    public static void main(String[] args) {
        System.out.println(new C06TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
