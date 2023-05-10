package com.zyh.interview.algorithm.p7dp.a2knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 多重背包
 * @author：zhanyh
 * @date: 2023/5/7
 * https://www.dotcpp.com/oj/problem2048.html
 * 把多重背包展开成01背包。
 */
public class C02MultipleKnapsackConvert01Knapsack {
    private int[][] memo;

    public int bestValue(int[] ws, int[] vs, int[] cs, int C) {
        int n = ws.length;
        if (n != vs.length || n != cs.length)
            return 0;
        if (n == 0 || C == 0)
            return 0;
        List<Integer> weights = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cs[i]; j++) {
                weights.add(ws[i]);
                values.add(vs[i]);
            }
        }
        memo = new int[values.size()][C + 1];
        for (int i = 0; i < values.size(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return bestValueCore(weights, values, values.size() - 1, C);
    }

    private int bestValueCore(List<Integer> weights, List<Integer> values, int index, int C) {
        if (index < 0 || C <= 0)
            return 0;
        if (memo[index][C] != -1)
            return memo[index][C];

        int res;
        res = bestValueCore(weights, values, index - 1, C);
        if (C - weights.get(index) >= 0)
            res = Math.max(res, values.get(index) + bestValueCore(weights, values, index - 1, C - weights.get(index)));
        memo[index][C] = res;
        return memo[index][C];
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
        System.out.println(new C02MultipleKnapsackConvert01Knapsack().bestValue(ws, vs, cs, C));
    }
}
