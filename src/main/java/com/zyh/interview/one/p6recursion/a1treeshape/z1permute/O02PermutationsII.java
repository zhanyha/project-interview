package com.zyh.interview.one.p6recursion.a1treeshape.z1permute;

import java.util.*;

/**
 * @description: LCR 084. 全排列 II
 * @author：zhanyh
 * @date: 2023/8/6
 */
// https://leetcode.cn/problems/7p8L0Z/
public class O02PermutationsII {
    private boolean[] visited;
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        visited = new boolean[nums.length];
        permuteUniqueCore(nums, list);
        return res;
    }

    private void permuteUniqueCore(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            res.add( new ArrayList<>(list) );
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            if(!visited[i]){
                if(i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                list.add(nums[i]);
                permuteUniqueCore(nums, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
