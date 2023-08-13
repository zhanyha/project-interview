package com.zyh.interview.one.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 279. 完全平方数
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class O05PerfectSquares {

    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j * j <= i; j ++){
                memo[i] = Math.min(memo[i], 1 + memo[i - j*j]);
            }
        }

        return memo[n];
    }
}
