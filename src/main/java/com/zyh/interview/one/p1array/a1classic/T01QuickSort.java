package com.zyh.interview.one.p1array.a1classic;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/17
 */
// https://leetcode.cn/problems/sort-an-array/
public class T01QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = partition(nums, l, r);
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, left, left + (int) (Math.random() * (right - left)));
        int base = left ;
        while (left <= right) {
            while (left <= right && nums[left] <= nums[base])
                left++;
            while (left <= right && nums[right] > nums[base])
                right--;
            if (left < right)
                swap(nums, right, left);
        }
        swap(nums, right, base);
        return right;
    }

    private void swap(int[] nums, int right, int base) {
        int t = nums[right];
        nums[right] = nums[base];
        nums[base] = t;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T01QuickSort().sortArray(new int[]{5, 2, 7, 1, 9, 3, 8, 6})));
    }
}
