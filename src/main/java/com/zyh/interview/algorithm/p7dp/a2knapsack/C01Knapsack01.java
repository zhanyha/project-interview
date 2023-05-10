package com.zyh.interview.algorithm.p7dp.a2knapsack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 01 背包问题
 * @author：zhanyh
 * @date: 2023/5/7
 * https://www.dotcpp.com/oj/problem1924.html
 * 输入：
 * ws 1   2   3
 * vs 6  10  12
 * C: 5
 * 输出：
 * 22
 */
public class C01Knapsack01 {
    private int[][] memo;

    public int bestValue(int[] ws, int[] vs, int C) {
        if (ws.length != vs.length)
            return 0;
        if (ws.length == 0)
            return 0;
        memo = new int[ws.length][C + 1];
        for (int i = 0; i < ws.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return bestValueCore(ws, vs, C, 0);
    }

    private int bestValueCore(int[] ws, int[] vs, int c, int index) {
        if (c == 0)
            return 0;
        if (index >= ws.length)
            return 0;
        if (memo[index][c] != -1)
            return memo[index][c];

        int res = -1;
        if (c >= ws[index]) {
            res = vs[index] + bestValueCore(ws, vs, c - ws[index], index + 1);
        }
        res = Math.max(res, bestValueCore(ws, vs, c, index + 1));
        memo[index][c] = res;
        return memo[index][c];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] ws = new int[n];
        int[] vs = new int[n];
        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        System.out.println(new C01Knapsack01().bestValue(ws, vs, c));
    }

}
