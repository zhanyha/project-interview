package com.zyh.interview.one.p2find.a4fourthstage;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/contains-duplicate-ii/
public class O10ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0, r = 0;
        Set<Integer> set = new HashSet<>();
        while (r < nums.length) {
            int n = nums[r];
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
            r++;
            if (r - l > k)
                l++;
        }
        return false;
    }


}
