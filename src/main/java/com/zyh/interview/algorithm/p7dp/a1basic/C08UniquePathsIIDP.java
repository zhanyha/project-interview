package com.zyh.interview.algorithm.p7dp.a1basic;

/**
 * @description: 63. 不同路径 II
 * @author：zhanyh
 * @date: 2023/5/4
 */
public class C08UniquePathsIIDP {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        memo[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 0 ? 1 : 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (memo[i][j] == 0) {
                    memo[i][j] += i + 1 < m ? (obstacleGrid[i + 1][j] == 1 ? 0 : memo[i + 1][j]) : 0;
                    memo[i][j] += j + 1 < n ? (obstacleGrid[i][j + 1] == 1 ? 0 : memo[i][j + 1]) : 0;
                }
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new C08UniquePathsIIDP().uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }
}
