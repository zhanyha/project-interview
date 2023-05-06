package com.zyh.interview.algorithm.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 62. 不同路径
 * @author：zhanyh
 * @date: 2023/5/4
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 输入：m = 3, n = 7
 * 输出：28
 */
public class C07UniquePaths {
    private int m;
    private int n;

    private int[][] memo;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        this.memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return uniquePathsCore(0, 0);
    }

    private int uniquePathsCore(int x, int y) {
        if (x >= m || y >= n)
            return 0;
        if(memo[x][y] != -1)
            return memo[x][y];
        if (x == m - 1 && y == n - 1)
            return 1;
        int res = 0;
        res += uniquePathsCore(x + 1, y);
        res += uniquePathsCore(x, y + 1);
        memo[x][y] = res;
        return memo[x][y];
    }

    public static void main(String[] args) {
        System.out.println(new C07UniquePaths().uniquePaths(3, 7));
    }
}
