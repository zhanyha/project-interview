package com.zyh.interview.one.p6recursion.a1treeshape.z2combine;

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
public class O03CombinationSumII {

    private List<List<Integer>> res;
    private boolean[] visited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        visited = new boolean[candidates.length];
        List<Integer> list = new ArrayList<>();
        res =  new ArrayList<>();
        combinationSum2Core(candidates, 0, target, list);
        return res;
    }

    private void combinationSum2Core(int[] candidates, int start, int target,List<Integer> list){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){

            if(i > 0 && candidates[i-1] == candidates[i] && !visited[i - 1]) continue;

            visited[i] = true;
            list.add(candidates[i]);
            combinationSum2Core(candidates, i + 1, target - candidates[i], list);
            list.remove(list.size() - 1);
            visited[i] = false;

        }
    }
}
