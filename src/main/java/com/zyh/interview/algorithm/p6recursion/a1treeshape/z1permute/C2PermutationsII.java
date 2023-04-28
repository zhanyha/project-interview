package com.zyh.interview.algorithm.p6recursion.a1treeshape.z1permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 全排列 II
 * @author：zhanyh
 * @date: 2023/4/26
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class C2PermutationsII {
    private boolean[] used;
    private List<List<Integer>> res;

    private HashSet<String> set;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        set = new HashSet<>();
        res = new ArrayList<>();
        used = new boolean[nums.length];
        if(nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        permuteUniqueCore(nums, list);
        return res;
    }

    private void permuteUniqueCore(int[] nums, List<Integer> list) {
        if(list.size() == nums.length){
            String s = convertToString(list);
            if(!set.contains(s)) {
                res.add(new ArrayList<>(list));
                set.add(s);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                used[i] = true;
                list.add(nums[i]);
                permuteUniqueCore(nums, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    private String convertToString(List<Integer> list) {
        StringBuilder sbr = new StringBuilder();
        for (Integer e : list) {
            sbr.append(e);
        }
        return sbr.toString();
    }
}
