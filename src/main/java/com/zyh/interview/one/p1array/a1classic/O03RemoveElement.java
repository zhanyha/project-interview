package com.zyh.interview.one.p1array.a1classic;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/remove-element/
public class O03RemoveElement {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                int t = nums[p];
                nums[p] = nums[i];
                nums[i] = t;
                p++;
            }
        }
        return p+1;
    }
}
