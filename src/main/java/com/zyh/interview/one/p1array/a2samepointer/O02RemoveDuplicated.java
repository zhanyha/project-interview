package com.zyh.interview.one.p1array.a2samepointer;

//https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
public class O02RemoveDuplicated {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if(write - 1 < 0 || nums[cur] != nums[write - 1]){
                nums[write] = nums[cur];
                write++;
            }
        }
        return write;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3,4,4,5,6,6};
        new O02RemoveDuplicated().removeDuplicates(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] +" ");
        }
    }
}
