package com.zyh.interview.algorithm.p7dp;

/**
 * @description: 64. 最小路径和
 * @author：zhanyh
 * @date: 2023/4/30
 */
public class C03MinimumPathSumDP {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        memo[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (!(i == m - 1 && j == n - 1))
                    memo[i][j] = grid[i][j] + Math.min(i + 1 >= m ? Integer.MAX_VALUE : memo[i + 1][j], j + 1 >= n ? Integer.MAX_VALUE : memo[i][j + 1]);
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        new C03MinimumPathSumDP().minPathSum(grid);
    }
}
