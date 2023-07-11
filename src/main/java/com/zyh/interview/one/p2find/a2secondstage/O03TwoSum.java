package com.zyh.interview.one.p2find.a2secondstage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/two-sum/
public class O03TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if(map.containsKey(left)){
                return new int[]{i, map.get(left)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
