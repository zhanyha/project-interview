package com.zyh.interview.algorithm.p6recursion.a1treeshape.z1permute;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 全排列
 * @author：zhanyh
 * @date: 2023/4/26
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class C1Permutations {
    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        used = new boolean[nums.length];
        if (nums.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        permuteCore(nums, list);
        return res;
    }

    private void permuteCore(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                permuteCore(nums, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
