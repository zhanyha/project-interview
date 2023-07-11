package com.zyh.interview.one.p2find.a4fourthstage;

import java.util.Set;
import java.util.TreeSet;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/contains-duplicate-iii/
public class O11ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int l = 0, r = 0;
        TreeSet<Integer> set = new TreeSet<>();
        while (r < nums.length) {
            int n = nums[r];
            Integer ceil = set.ceiling(n);
            if (ceil != null && ceil <= n + valueDiff) {
                return true;
            }
            set.add(n);
            r++;
            if (r - l > indexDiff) {
                l++;
                set.remove(nums[l]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new O11ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }
}
