package com.zyh.interview.one.p1array.a1classic;

import java.util.Arrays;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/17
 */
// https://leetcode.cn/problems/sort-an-array/
public class T01QuickSortBest {
    public int[] sortArray(int[] nums) {
        quickSort3(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort3(int[] nums, int l, int r) {
        if (l >= r) return;
        swap(nums, l, l + (int) (Math.random() * (r - l)));
        int base = l;
        int lt = l, gt = r + 1, i = l + 1;
        while (i < gt) {
            if (nums[i] < nums[base]) {
                swap(nums, i, lt + 1);
                lt++;
                i++;
            } else if (nums[i] > nums[base]) {
                swap(nums, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(nums, base, lt);

        quickSort3(nums, l, lt - 1);
        quickSort3(nums, gt, r);

    }


    private void swap(int[] nums, int right, int base) {
        int t = nums[right];
        nums[right] = nums[base];
        nums[base] = t;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T01QuickSortBest().sortArray(new int[]{5, 2, 7, 1, 9, 3, 8, 6})));
    }
}
