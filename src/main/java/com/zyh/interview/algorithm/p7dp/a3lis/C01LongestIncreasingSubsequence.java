package com.zyh.interview.algorithm.p7dp.a3lis;

import java.util.Arrays;

/**
 * @description: 300. 最长递增子序列
 * @author：zhanyh
 * @date: 2023/5/8
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class C01LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j])
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
            }
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new C01LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
