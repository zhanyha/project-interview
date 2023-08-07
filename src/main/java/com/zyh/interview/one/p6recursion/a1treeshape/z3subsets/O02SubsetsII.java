package com.zyh.interview.one.p6recursion.a1treeshape.z3subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 90. 子集 II
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O02SubsetsII {
    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        res = new ArrayList<>();
        List<Integer> list =  new ArrayList<>();
        subsetsWithDupCore(nums, 0 , list);
        return res;
    }

    private void subsetsWithDupCore(int[] nums, int start , List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            subsetsWithDupCore(nums,  i + 1, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
