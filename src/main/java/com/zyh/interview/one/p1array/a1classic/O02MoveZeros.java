package com.zyh.interview.one.p1array.a1classic;

import java.util.Arrays;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/move-zeroes/
public class O02MoveZeros {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, p, cur);
                p++;
            }
        }
    }

    private void swap(int[] nums, int i, int k) {
        int t = nums[i];
        nums[i] = nums[k];
        nums[k] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 0, 0, 3};

        new O02MoveZeros().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
