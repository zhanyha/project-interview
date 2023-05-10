package com.zyh.interview.algorithm.p7dp.a2knapsack;

import java.util.Scanner;

/**
 * @description: 多重背包
 * @author：zhanyh
 * @date: 2023/5/7
 * https://www.dotcpp.com/oj/problem2048.html
 * 递归解法
 */
public class C02MultipleKnapsack {
    private int[][] memo;

    public int bestValue(int[] ws, int[] vs, int[] cs, int C) {
        int n = ws.length;
        if (n != vs.length || n != cs.length)
            return 0;
        if (n == 0 || C == 0)
            return 0;

        return bestValueCore(ws, vs, cs, n - 1, C);
    }

    private int bestValueCore(int[] ws, int[] vs, int[] cs, int index, int C) {
        if(C <= 0 || index < 0)
            return 0;
        int res = 0;
        if(cs[index] - 1 >= 0 && C - ws[index] >= 0) {
            cs[index] -= 1;
            res = vs[index] + bestValueCore(ws, vs, cs, index, C - ws[index]);
            cs[index] += 1;
        }
        res = Math.max(res, bestValueCore(ws, vs, cs, index - 1, C));
        return res;
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
        System.out.println(new C02MultipleKnapsack().bestValue(ws, vs, cs, C));
    }
}
