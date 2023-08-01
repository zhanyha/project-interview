package com.zyh.interview.one.p5tree.a1travel;

import com.zyh.interview.algorithm.p7dp.a2knapsack.C01Knapsack01DP;

import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/path-sum/
public class O08PathSum {


    public int bestValue(int[] ws, int[] vs, int C) {
        int n = ws.length;
        if (n != vs.length)
            return 0;
        if (n == 0 || C == 0)
            return 0;
        int[][] memo = new int[n][C + 1];
        for (int c = 0; c < C + 1; c++) {
            if (c >= ws[n - 1])
                memo[n - 1][c] = vs[n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < C + 1; j++) {
                memo[i][j] = j - ws[i] >= 0 ? vs[i] + memo[i + 1][j - ws[i]] : 0;
                memo[i][j] = Math.max(memo[i][j], memo[i + 1][j]);
            }
        }
        return memo[0][C];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] ws = new int[n];
        int[] vs = new int[n];
        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        System.out.println(new C01Knapsack01DP().bestValue(ws, vs, c));
    }
}
