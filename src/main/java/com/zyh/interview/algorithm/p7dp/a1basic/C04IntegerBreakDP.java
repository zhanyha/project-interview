package com.zyh.interview.algorithm.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 343. 整数拆分
 * @author：zhanyh
 * @date: 2023/4/30
 */
public class C04IntegerBreakDP {

    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }
    private int max3(int res, int n, int m) {
        return Math.max(Math.max(res, n), m);
    }
}
