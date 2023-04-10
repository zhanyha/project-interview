package com.zyh.interview.algorithm.p2find.a1set;

import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 存在重复元素
 * @author：zhanyh
 * @date: 2023/4/10
 * 给你一个整数数组 nums。
 * 如果任一值在数组中出现至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class C15ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
