package com.zyh.interview.algorithm.p2find.a2map;

/**
 * @author zhanyh
 * @time 2023/3/22 21:44
 */

import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * -1, 0, 1, 2, -1, -4
 * [-1,-1,2],[-1,-1, 0]
 */
public class C6ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 保证了结果的有序性，用于去重
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<String> checkSet = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = -nums[i] - nums[j];
                if (map.containsKey(left) && map.get(left) > j
                        && !checkSet.contains(nums[i] + " " + nums[j] + " " + left)) {
                    checkSet.add(nums[i] + " " + nums[j] + " " + left);
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(left);
                    res.add(integers);
                }
            }
        }
        return res;
    }
}
