package com.zyh.interview.algorithm.p7dp;

import java.util.Arrays;

/**
 * @description: 279. 完全平方数
 * @author：zhanyh
 * @date: 2023/5/1
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 */
public class C05PerfectSquares {
    private int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return numSquaresCore(n);
    }

    private int numSquaresCore(int n) {
        if (memo[n] != -1)
            return memo[n];
        if (n == 1)
            return 1;
        if (n == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 1; n - i * i >= 0; i++) {
            res = Math.min(res, 1 + numSquaresCore(n - i * i));
        }
        memo[n] = res;
        return memo[n];
    }
}
