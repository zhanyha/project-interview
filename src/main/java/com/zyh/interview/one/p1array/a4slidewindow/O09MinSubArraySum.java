package com.zyh.interview.one.p1array.a4slidewindow;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/minimum-size-subarray-sum/
public class O09MinSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = -1;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (r <= nums.length - 1) {
            if (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            } else {
                r++;
                if(r <= nums.length - 1 )
                    sum += nums[r];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4,1, 3};
        System.out.println(new O09MinSubArraySum().minSubArrayLen(7, nums));
    }
}
