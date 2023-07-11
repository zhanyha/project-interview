package com.zyh.interview.one.p2find.a2secondstage;

import java.util.*;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/3sum/
public class O04ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = -nums[i] - nums[j];
                if (map.containsKey(left) && map.get(left) > j && !set.contains(nums[i] + "" + nums[j] + "" + left)) {
                    List<Integer> line = new ArrayList<>();
                    line.add(nums[i]);
                    line.add(nums[j]);
                    line.add(left);
                    res.add(line);
                    set.add(nums[i] + "" + nums[j] + "" + left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O04ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
