package com.zyh.interview.algorithm.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 343. 整数拆分
 * @author：zhanyh
 * @date: 2023/4/30
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class C04IntegerBreak {
    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return integerBreakCore(n);
    }

    private int integerBreakCore(int n) {
        if (n == 1)
            return 1;
        if (memo[n] != -1)
            return memo[n];

        int res = 0;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * integerBreak(n - i));
        }
        memo[n] = res;
        return memo[n];
    }

    private int max3(int res, int n, int m) {
        return Math.max(Math.max(res, n), m);
    }

    public static void main(String[] args) {
        new C04IntegerBreak().integerBreak(10);
    }

}
