package com.zyh.interview.algorithm.p9classic;

import java.util.Arrays;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/10
 */
public class C02MergeSort {
    private int res = 0;

    public int sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] arr = new int[right - left + 1];
        int l = left, r = mid + 1;
        int cur = l;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                nums[cur++] = arr[l++];
            } else {
                nums[cur++] = arr[r++];
                res += mid - l + 1;
            }
        }
        while (l <= mid) {
            nums[cur++] = arr[l++];
        }
        while (r <= right) {
            nums[cur++] = arr[r++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(new C02MergeSort().sort(nums));
    }
}
