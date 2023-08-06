package com.zyh.interview.one.p6recursion.a1treeshape.z1permute;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: LCR 083. 全排列
 * @author：zhanyh
 * @date: 2023/8/6
 */
// https://leetcode.cn/problems/VvJkup/description/
public class O01Permutations {

    private List<List<Integer>> res;
    private boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permuteCore(nums, list);

        return res;
    }

    public void permuteCore(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i< nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                permuteCore(nums, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
