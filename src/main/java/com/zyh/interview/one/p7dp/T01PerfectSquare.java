package com.zyh.interview.one.p7dp;


/**
 * @description: 完全平方数
 * @author：zhanyh
 * @date: 2023/7/21
 */
// https://leetcode.cn/problems/perfect-squares/
public class T01PerfectSquare {
    private int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];
        return numSquaresCore(n);
    }

    private int numSquaresCore(int n) {
        if (memo[n] != 0)
            return memo[n];
        if (n == 1) {
            return 1;
        }
        if (n == 0)
            return 0;
        int res = n;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, 1 + numSquaresCore(n - i * i));
        }
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T01PerfectSquare().numSquares(12));
    }
}
