package com.zyh.interview.algorithm.p6recursion.a1treeshape.z2combine;

import java.util.*;

/**
 * @description: 组合总和 II
 * @author：zhanyh
 * @date: 2023/4/26
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [[1,2,2],[5]]
 */
public class C3CombinationSumIIBestMethod {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        if (candidates.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        combinationSum2Core(candidates, 0, used, target, list);
        return res;
    }

    private void combinationSum2Core(int[] candidates, int start, boolean[] used, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1])
                continue;
            if (target - candidates[i] >=0 && !used[i]) {
                used[i] = true;
                list.add(candidates[i]);
                combinationSum2Core(candidates, i + 1, used, target - candidates[i], list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 5};
        System.out.println(new C3CombinationSumIIBestMethod().combinationSum2(nums, 5));
    }
}
