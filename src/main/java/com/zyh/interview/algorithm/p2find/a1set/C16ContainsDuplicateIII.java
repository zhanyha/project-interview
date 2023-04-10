package com.zyh.interview.algorithm.p2find.a1set;

import java.util.TreeSet;

/**
 * @description: 重复的元素III
 * @author：zhanyh
 * @date: 2023/4/10
 * 给你一个整数数组 nums 和两个整数k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，
 * 同时又满足 abs(i - j) <= k 。
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * 0 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k(valueDiff) <= 10^4
 * 0 <= t(indexDiff) <= 2^31 - 1
 * 1 2 1 1
 * 1
 * 0
 */
public class C16ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int l = 0, r = Math.min(indexDiff, nums.length);
        TreeSet<Long> set = new TreeSet<>();
        Long ceiling;
        for (int i = l; i < r; i++) {
            ceiling = set.ceiling((long) (nums[i] - valueDiff));
            if (ceiling != null && ceiling <= nums[i] + valueDiff) {
                return true;
            }
            set.add((long) nums[i]);
        }
        while (r < nums.length) {
            ceiling = set.ceiling((long) (nums[r] - valueDiff));
            if (ceiling != null && ceiling <= (long) nums[r] + (long) valueDiff) {
                return true;
            } else {
                set.remove((long) nums[l++]);
                set.add((long) nums[r++]);
            }
        }
        return false;
    }
}
