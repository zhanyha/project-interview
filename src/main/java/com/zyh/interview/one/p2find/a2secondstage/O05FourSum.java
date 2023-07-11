package com.zyh.interview.one.p2find.a2secondstage;

import java.util.*;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/4sum/
public class O05FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        long left;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    left = target -nums[i] - nums[j] - nums[k];
                    if (map.containsKey(left) && map.get(left) > k
                            && !set.contains(nums[i] + "" + nums[j] + "" + nums[k] + "" + left)) {
                        set.add(nums[i] + "" + nums[j] + "" + nums[k] + "" + left);
                        List<Integer> line = new ArrayList<>();
                        line.add(nums[i]);
                        line.add(nums[j]);
                        line.add(nums[k]);
                        line.add((int) left);
                        res.add(line);
                    }
                }
            }
        }
        return res;
    }
}
