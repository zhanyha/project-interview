package com.zyh.interview.one.p7dp.a1basic;

/**
 * @description: 70. 爬楼梯
 * @author：zhanyh
 * @date: 2023/8/9
 */
// https://leetcode.cn/problems/climbing-stairs/
public class O01ClimbingStairs {
    private int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        return climbCore(n);
    }

    public int climbStairsDP(int n) {
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2; i <= n; i++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
    public int climbCore(int n) {
        if(n == 1 || n == 0) return 1;
        if(memo[n] != 0)
            return memo[n];
        memo[n] = climbCore(n - 1) + climbCore(n - 2);
        return memo[n];
    }
}
