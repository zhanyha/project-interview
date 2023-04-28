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
public class C3CombinationSumII {

    private List<List<Integer>> res;
    private Set<String> set;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        set = new HashSet<>();
        if(candidates.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        combinationSum2Core(candidates, 0, target, list);
        return res;
    }

    private void combinationSum2Core(int[] candidates, int index, int target, List<Integer> list) {
        if(target == 0){
            String key = list2Str(list);
            if(!set.contains(key)) {
                res.add(new ArrayList<>(list));
                set.add(key);
            }
            return;
        }
        if(target < 0 || index >= candidates.length)
            return;
        list.add(candidates[index]);
        combinationSum2Core(candidates, index + 1, target - candidates[index], list);
        list.remove(list.size() - 1);
        combinationSum2Core(candidates, index + 1, target, list);
    }

    private String list2Str(List<Integer> list) {
        StringBuilder sbr = new StringBuilder();
        for (Integer integer : list) {
            sbr.append(integer);
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,5};
        System.out.println(new C3CombinationSumII().combinationSum2(nums, 5));
    }
}
