package com.zyh.interview.one.p1array.a3collidingpointer;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/

public class O01TowSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                return new int[]{l, r};
            }
        }
        return null;
    }
}
