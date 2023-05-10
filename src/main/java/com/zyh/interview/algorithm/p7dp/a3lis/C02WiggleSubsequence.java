package com.zyh.interview.algorithm.p7dp.a3lis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 376. 摆动序列
 * @author：zhanyh
 * @date: 2023/5/8
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 */
public class C02WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] diffs = new int[n - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (!set.contains(nums[i]))
                set.add(nums[i]);
        }
        int[] memo = new int[n - 1];
        Arrays.fill(memo, 1);
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if ((diffs[i] > 0 && diffs[j] < 0) || (diffs[i] < 0 && diffs[j] > 0))
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
            }
        }
        int res = -1;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return res <= 1 ? 1 : res + 1;
    }

    public static void main(String[] args) {
        System.out.println(new C02WiggleSubsequence().wiggleMaxLength(new int[]{2, 3}));
    }
}
