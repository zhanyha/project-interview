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
 * [1,2,1],
 * [2,1,1]]
 */
public class C2PermutationsIIBestMethod {
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        if (nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        permuteUniqueCore(nums, list, used);
        return res;
    }

    private void permuteUniqueCore(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                permuteUniqueCore(nums, list,used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new C2PermutationsIIBestMethod().permuteUnique(new int[]{1, 2, 2}));
    }

}
