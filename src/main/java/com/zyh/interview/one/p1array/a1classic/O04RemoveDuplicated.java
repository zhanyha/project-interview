package com.zyh.interview.one.p1array.a1classic;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
public class O04RemoveDuplicated {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                swap(nums, i, p);
                continue;
            }
            p++;
        }
        return p;
    }

    private void swap(int[] nums, int i, int p) {
        int t = nums[i];
        nums[i] = nums[p];
        nums[p] = t;
    }
}
