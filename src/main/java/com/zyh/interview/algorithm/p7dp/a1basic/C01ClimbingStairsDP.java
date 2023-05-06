package com.zyh.interview.algorithm.p7dp.a1basic;

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
public class C01ClimbingStairsDP {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new C01ClimbingStairsDP().climbStairs(3));
    }
}
