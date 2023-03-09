/**
 * @author zhanyuhao
 * @time 2023/2/7 14:20
 */
package com.zyh.interview.algorithm.p1arrays.a1经典;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">L215</a>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 1 2 2 3 3 4 5 5 6
 * 输出: 4
 */
public class C04KthElement {
    private int res;
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        res = -1;
        findKHelper(nums, k - 1, l, r);
        System.out.println(nums[res]);
        return nums[res];
    }

    private void findKHelper(int[] nums, int k, int l, int r) {
        int pos = partition(nums, l, r);
        if (pos == k) {
            res = pos;
        }
        else if (pos < k) {
            findKHelper(nums, k, pos + 1, r);
        } else {
           findKHelper(nums, k, l, pos - 1);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int base = l; // 这里要注意 = l
        while (l <= r) {
            while (l <= r && nums[l] >= nums[base])
                l++;
            while (l <= r && nums[r] <= nums[base])
                r--;
            if (l < r)
                swap(nums, l, r);
        }
        swap(nums, r, base); // 永远和左边的交换， 也就是r
        return r;
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2};
        new C04KthElement().findKthLargest(nums, 2);
    }
}
