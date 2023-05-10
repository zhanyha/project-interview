package com.zyh.interview.algorithm.p7dp.a2knapsack;

import java.util.Scanner;

/**
 * @description: 多重背包
 * @author：zhanyh
 * @date: 2023/5/7
 * https://www.dotcpp.com/oj/problem2048.html
 * 动态规划解法
 * memo[i][j] = Math.max(memo[i][j], k * vs[i] + memo[i - 1][j - k * ws[i]]);
 * 注意memo[i][j], 而不是memo[i-1][j], 因为k=0的时候 memo[i-1][j] = memo[i][j],
 * 但是后面k=1,2...n 的时候还需要和现在已知的最大值比较。
 */
public class C02MultipleKnapsackDP {

    public int bestValue(int[] ws, int[] vs, int[] cs, int C) {
        int n = ws.length;
        if (n != vs.length || n != cs.length)
            return 0;
        if (n == 0 || C == 0)
            return 0;
        int[][] memo = new int[n][C + 1];
        for (int i = 0; i < C + 1; i++)
            memo[0][i] = Math.min(cs[0], i / ws[0]) * vs[0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= C; j++) {
                for (int k = 0; k <= Math.min(cs[i], j / ws[i]); k++) {
                    memo[i][j] = Math.max(memo[i][j], k * vs[i] + memo[i - 1][j - k * ws[i]]);
                }
            }
        }
        return memo[n - 1][C];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C = sc.nextInt();
        int[] ws = new int[n];
        int[] vs = new int[n];
        int[] cs = new int[n];
        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
            cs[i] = sc.nextInt();
        }
        System.out.println(new C02MultipleKnapsackDP().bestValue(ws, vs, cs, C));
    }
}
