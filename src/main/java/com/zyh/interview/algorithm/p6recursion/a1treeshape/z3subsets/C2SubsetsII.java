package com.zyh.interview.algorithm.p6recursion.a1treeshape.z3subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class C2SubsetsII {
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        subsetsWithDupCore(nums, 0, list);
        return res;
    }

    private void subsetsWithDupCore(int[] nums, int i, List<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (i < nums.length) {
            list.add(nums[i]);
            subsetsWithDupCore(nums, i + 1, list);
            list.remove(list.size() - 1);
            subsetsWithDupCore(nums, i + 1, list);
        }
    }
}
