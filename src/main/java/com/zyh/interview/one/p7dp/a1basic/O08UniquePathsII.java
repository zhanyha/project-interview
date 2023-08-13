package com.zyh.interview.one.p7dp.a1basic;

/**
 * @description: 63. 不同路径 II
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class O08UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        if(obstacleGrid[m-1][n-1] == 1) return 0;

        int[][] memo = new int[m][n];
        memo[m - 1][n - 1] = 1;

        for(int i = m - 1; i >= 0 ; i--){
            for(int j = n-1; j >=0; j--){
                if(i == m - 1 && j == n - 1) continue;

                memo[i][j] += (i + 1 < m && obstacleGrid[i + 1][j] == 0) ? memo[i + 1][j] : 0;
                memo[i][j] += (j + 1 < n && obstacleGrid[i][j + 1] == 0) ? memo[i][j + 1] : 0;
            }
        }

        return memo[0][0];
    }
}
