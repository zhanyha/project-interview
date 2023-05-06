package com.zyh.interview.algorithm.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 63. 不同路径 II
 * @author：zhanyh
 * @date: 2023/5/4
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * m ==obstacleGrid.length
 * n ==obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */
public class C08UniquePathsII {
    private int m, n;
    private int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return uniquePathsWithObstaclesCore(obstacleGrid, 0, 0);
    }


    private int uniquePathsWithObstaclesCore(int[][] obstacleGrid, int x, int y) {
        if (x >= m || y >= n)
            return 0;
        if(memo[x][y] != -1)
            return memo[x][y];
        if (obstacleGrid[x][y] == 1)
            return 0;
        if (x == m - 1 && y == n - 1)
            return 1;
        int res = 0;
        res += uniquePathsWithObstaclesCore(obstacleGrid, x + 1, y);
        res += uniquePathsWithObstaclesCore(obstacleGrid, x, y + 1);
        memo[x][y] = res;
        return memo[x][y];
    }
}
