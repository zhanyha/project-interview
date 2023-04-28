package com.zyh.interview.algorithm.p6recursion.a1treeshape.z3subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class C2SubsetsIIBestMethod {
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        subsetsWithDupCore(nums, 0, used, list);
        return res;
    }

    private void subsetsWithDupCore(int[] nums, int start, boolean[] used, List<Integer> list) {
        res.add(new ArrayList<>(list));
        if (start >= nums.length)
            return;

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            list.add(nums[i]);
            used[i] = true;
            subsetsWithDupCore(nums, i + 1, used, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new C2SubsetsIIBestMethod().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
