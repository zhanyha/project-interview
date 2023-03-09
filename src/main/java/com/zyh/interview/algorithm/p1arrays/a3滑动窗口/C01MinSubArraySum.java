/**
 * @author zhanyuhao
 * @time 2023/2/7 14:58
 */
package com.zyh.interview.algorithm.p1arrays.a3滑动窗口;

// https://leetcode.cn/problems/minimum-size-subarray-sum/

/**
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 */
public class C01MinSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0; // [l, r) 的和是否大于target
        int sum = 0;
        int len = nums.length + 1;
        while (l < nums.length) {
            if (r < nums.length && sum < target) {
                sum += nums[r];
                r++;
            } else {
                sum -= nums[l];
                l++;
            }
            if(sum >= target)
                len = Math.min(len, r - l);
        }
        return len == nums.length + 1 ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(new C01MinSubArraySum().minSubArrayLen(15, nums));
    }
}
