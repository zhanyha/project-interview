package com.zyh.interview.algorithm.p6recursion.a1treeshape.z2combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: L39 组合总和
 * @author：zhanyh
 * @date: 2023/4/26
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 */
public class C2CombinationSumMehtod2 {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumCore(candidates, 0, target, list);
        return res;
    }

    private void combinationSumCore(int[] candidates, int start, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                list.add(candidates[i]);
                combinationSumCore(candidates, i, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(new C2CombinationSumMehtod2().combinationSum(nums, target));
    }
}
