package com.zyh.interview.one.p6recursion.a1treeshape.z3subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: L78: 子集
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O01Subsets {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res =  new ArrayList<>();
        List<Integer> list =  new ArrayList<>();
        res.add(list);
        subsetsCore(nums, 0, list);
        return res;
    }
    public void subsetsCore(int[] nums, int start, List<Integer> list){
        for(int i = start;  i < nums.length; i ++){
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            subsetsCore(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
