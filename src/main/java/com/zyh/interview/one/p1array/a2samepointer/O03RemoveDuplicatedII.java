package com.zyh.interview.one.p1array.a2samepointer;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
public class O03RemoveDuplicatedII {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (write - 2 < 0 || nums[write - 2] != nums[cur]) {
                nums[write] = nums[cur];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        new O03RemoveDuplicatedII().removeDuplicates(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
