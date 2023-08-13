package com.zyh.interview.one.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 64. 最小路径和
 * @author：zhanyh
 * @date: 2023/8/9
 */
public class O03MinimumPathSum {

    private int[][] memo;
    private int m, n;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], 200 * 200 * 200 + 1);
        minPathSumDP(grid);
        return minPathSumCore(grid, 0, 0);
    }

    public int minPathSumDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];

        memo[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i != m - 1 || j != n - 1)
                    memo[i][j] = grid[i][j] + Math.min(
                            i + 1 < m ? memo[i + 1][j] : 200 * 200 * 200 + 1,
                            j + 1 < n ? memo[i][j + 1] : 200 * 200 * 200 + 1
                    );
            }
        }

        return memo[0][0];
    }

    public int minPathSumCore(int[][] grid, int x, int y) {
        if (x >= m || y >= n) {
            return 200 * 200 * 200 + 1;
        }
        if (x == m - 1 && y == n - 1)
            return grid[x][y];
        if (memo[x][y] != 200 * 200 * 200 + 1)
            return memo[x][y];

        int res1 = grid[x][y] + minPathSumCore(grid, x, y + 1);

        int res2 = grid[x][y] + minPathSumCore(grid, x + 1, y);
        memo[x][y] = Math.min(res1, res2);
        return memo[x][y];
    }


}
