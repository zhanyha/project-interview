package com.zyh.interview.one.p7dp.a2knapsack;

import java.util.Scanner;

/**
 * @description: 多重背包问题
 * @author：zhanyh
 * @date: 2023/8/13
 */
// https://www.dotcpp.com/oj/problem2048.html
public class O02MultipleKnapsack {

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
        System.out.println(new O02MultipleKnapsack().solve(ws, vs, cs, C));
        sc.close();
    }

    private int solve(int[] ws, int[] vs, int[] cs, int c) {
        int n = ws.length;
        int[] memo = new int[c + 1];
        for (int i = 1; i < c + 1; i++)
            memo[i] = i >= ws[0] ? Math.min(cs[0], i / ws[0]) * vs[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int j = c; j >= 0; j--) {
                for (int k = 1; k <= Math.min(cs[i], j / ws[i]); k++) {
                    memo[j] = Math.max(k * vs[i] + memo[j - k * ws[i]], memo[j]);
                }
            }
        }

        return memo[c];
    }
}
