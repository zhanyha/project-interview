package com.zyh.interview.leetcode.p7dp;

import com.zyh.interview.algorithm.p8bit.binary.C01AddBinary;

/**
 * @description: 乘积最大子数组
 * @author：zhanyh
 * @date: 2023/5/27
 */
public class C01MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxPositive = new int[n];
        int[] minNegative = new int[n];
        maxPositive[0] = nums[0];
        minNegative[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minNegative[i] = Math.min(nums[i], nums[i] < 0 ? nums[i] * maxPositive[i-1] : nums[i] * minNegative[i-1]);

            maxPositive[i] = Math.max(nums[i], nums[i] < 0 ? nums[i] * minNegative[i-1] : nums[i] * maxPositive[i-1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, maxPositive[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new C01MaximumProductSubarray().maxProduct(new int[]{-2, 2, 0, -1, 3, -7}));
    }
}
