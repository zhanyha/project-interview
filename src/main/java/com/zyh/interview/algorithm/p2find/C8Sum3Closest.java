package com.zyh.interview.algorithm.p2find;

import java.util.*;

/**
 * @description: 给你一个长度为 n 的整数数组nums和 一个目标值target。
 * 请你从 nums 中选出三个整数，使它们的和与target最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * @author：zhanyh
 * @date: 2023/3/30
 * <p>
 * d  = (x + y) + (z - target)
 * 两次for 分别求 x + y,  z - target
 * O(n^2)
 */
public class C8Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int gap = target - nums[i];
            int closestTowSum = slideWindows(gap, nums, i + 1);
            if (distance > Math.abs(gap - closestTowSum)) {
                distance = Math.abs(gap - closestTowSum);
                res = nums[i] + closestTowSum;
            }
        }
        return res;
    }

    private int slideWindows(int gap, int[] nums, int start) {
        int l = start, r = nums.length - 1;
        int towSum = 0;
        while (l < r) {
            towSum = nums[l] + nums[r];
            if(Math.abs(gap - towSum) > Math.abs(gap - (nums[l] + nums[r]))) {
                towSum = nums[l] + nums[r];
            }
            if (towSum == gap) {
                return towSum;
            }
            if (towSum < gap) {
                l++;
            } else {
                r--;
            }
        }
        return towSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 8, 9, 10};
        int target = 16;
        System.out.println(new C8Sum3Closest().threeSumClosest(nums, target));
    }
}
