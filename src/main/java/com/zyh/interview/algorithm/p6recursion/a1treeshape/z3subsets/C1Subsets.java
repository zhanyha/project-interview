package com.zyh.interview.algorithm.p6recursion.a1treeshape.z3subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * L78: 子集
 * 数组中的元素 互不相同
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class C1Subsets {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        subsetsCore(nums, 0, list);
        return res;
    }

    private void subsetsCore(int[] nums, int i, List<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (i < nums.length) {
            list.add(nums[i]);
            subsetsCore(nums, i + 1, list);
            list.remove(list.size() - 1);
            subsetsCore(nums, i + 1, list);
        }
    }
}
