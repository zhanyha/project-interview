package com.zyh.interview.algorithm.p2find.a1set;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: contains-duplicate-ii
 * @author：zhanyh
 * @date: 2023/4/10
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个不同的索引i和j ，满
 * 足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true；否则，返回 false。
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 * [1,2,3,1,2,3]
 * 2
 * 输出：true
 */
public class C13ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        int l = 0, r = l + k;
        Set<Integer> set = new HashSet<>();
        for (int i = l; i < r; i++) {
            if(i < nums.length ) {
                if (!set.contains(nums[i]))
                    set.add(nums[i]);
                else
                    return true;
            }
        }
        while (r < nums.length) {
            if (set.contains(nums[r]))
                return true;
            set.remove(nums[l++]);
            set.add(nums[r++]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{99, 99};
        System.out.println(new C13ContainsDuplicateII().containsNearbyDuplicate(nums, 2));
    }
}
