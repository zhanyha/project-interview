package com.zyh.interview.one.p4statckandqueue;

import java.util.Arrays;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/perfect-squares/
public class O07PerfectSquares {
    private int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return numSquareDP(n);
    }

    private int numSquaresCore(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (memo[n] != -1)
            return memo[n];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, 1 + numSquaresCore(n - i * i));
        }
        memo[n] = res;
        return memo[n];
    }

    private int numSquareDP(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                memo[i] = Math.min(memo[i], 1 + memo[i - j * j]);
            }
        }
        return memo[n];
    }

}
