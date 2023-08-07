package com.zyh.interview.one.p6recursion.a1treeshape.z2combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: LCR 081. 组合总和
 * @author：zhanyh
 * @date: 2023/8/6
 */
// https://leetcode.cn/problems/Ygoe9J/
public class O02CombinationSum {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        res = new ArrayList<>();
        combinationSumCore(candidates, 0, target, list);
        return res;
    }

    public void combinationSumCore(int[] candidates, int start, int target,List<Integer> list){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start ; i < candidates.length; i++){
            list.add(candidates[i]);
            combinationSumCore(candidates, i, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
