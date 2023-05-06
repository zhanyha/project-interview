package com.zyh.interview.algorithm.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 64. 最小路径和
 * @author：zhanyh
 * @date: 2023/4/30
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class C03MinimumPathSum {
    private int m;
    private int n;
    private int[][] memo;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return minPathSumCore(grid, 0, 0);
    }

    private int minPathSumCore(int[][] grid, int i, int j) {
        if (i >= m || j >= n)
            return Integer.MAX_VALUE - 10000000;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (i == m - 1 && j == n - 1)
            return grid[i][j];
        memo[i][j] = grid[i][j] + Math.min(minPathSumCore(grid, i + 1, j), minPathSumCore(grid, i, j + 1));
        return memo[i][j];
    }
}
