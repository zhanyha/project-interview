package com.zyh.interview.one.p7dp.a2knapsack;

import java.util.Scanner;

/**
 * @description:  01 背包
 * @author：zhanyh
 * @date: 2023/8/13
 */
// https://www.dotcpp.com/oj/problem1924.html
public class O01Knapsack01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C = sc.nextInt();
        int[] ws = new int[n];
        int[] vs = new int[n];
        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        System.out.println(new O01Knapsack01().solve(ws, vs, C));
        sc.close();
    }

    private int solve(int[] ws, int[] vs, int c) {
        int n = ws.length;
        int[][] dp = new int[n][c + 1];
        for (int i = 1; i < c + 1; i++)
            dp[0][i] = i >= ws[0] ? vs[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < c + 1; j++) {
                if(j >= ws[i]){
                    dp[i][j] = Math.max(dp[i - 1][j], vs[i] + dp[i - 1][j - ws[i]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][c];
    }
}
