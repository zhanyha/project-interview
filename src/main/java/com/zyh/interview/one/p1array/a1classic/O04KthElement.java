package com.zyh.interview.one.p1array.a1classic;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
//https://leetcode.cn/problems/kth-largest-element-in-an-array
public class O04KthElement {
    private int res = -1;

    public int findKthLargest(int[] nums, int k) {
        findKthLargest(nums, 0, nums.length - 1, k);
        return res != -1 ? nums[res] : -1;
    }

    private void findKthLargest(int[] nums, int start, int end, int k) {
        int p = findKthLargestCore(nums, start, end);
        if (nums.length - p == k) {
            res = p;
        } else if (nums.length - p < k) {
            findKthLargest(nums, start, p - 1, k);
        } else {
            findKthLargest(nums, p + 1, end, k);
        }
    }

    private int findKthLargestCore(int[] nums, int start, int end) {
        int base = start;
        int l = start, r = end;
        while (l <= r) {
            while (l <= r && nums[l] <= nums[base]) {
                l++;
            }
            while (l <= r && nums[r] > nums[base]) {
                r--;
            }
            if (l <= r)
                swap(nums, l, r);
        }
        swap(nums, base, r);
        return r;
    }

    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 7, 4};
        System.out.println(new O04KthElement().findKthLargest(nums, 2));
    }
}
