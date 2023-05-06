package com.zyh.interview.algorithm.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 70. 爬楼梯
 * @author：zhanyh
 * @date: 2023/4/29
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class C01ClimbingStairs {
    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsCore(n);
    }

    private int climbStairsCore(int n) {
        if (memo[n] != -1)
            return memo[n];
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        memo[n] = climbStairsCore(n - 1) + climbStairsCore(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new C01ClimbingStairs().climbStairs(3));
    }
}
