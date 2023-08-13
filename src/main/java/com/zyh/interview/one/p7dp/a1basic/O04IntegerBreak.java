package com.zyh.interview.one.p7dp.a1basic;

/**
 * @description: 343 整数拆分
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class O04IntegerBreak {
    private int[] memo;

    public int integerBreak(int n) {
//        memo = new int[n + 1];
        return integerBreakDP(n);
    }

    public int integerBreakDP(int n) {
        int[] memo = new int[n + 1];

        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = max3(memo[i], j * memo[i - j], j * (i - j));
            }
        }
        return memo[n];
    }

    public int integerBreakCore(int n) {
        if (n == 1) return 1;
        if (memo[n] != 0)
            return memo[n];
        int res = 0;
        for (int i = 1; i <= n / 2; i++) {
            res = max3(res, i * integerBreakCore(n - i), i * (n - i));
        }
        memo[n] = res;
        return memo[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
