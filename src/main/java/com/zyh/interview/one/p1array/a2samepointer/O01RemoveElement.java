package com.zyh.interview.one.p1array.a2samepointer;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/remove-element/
public class O01RemoveElement {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != val) {
                swap(nums, cur, p);
                p++;
            }
        }
        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};

        new O01RemoveElement().removeElement(nums, 2);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
