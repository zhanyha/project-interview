package com.zyh.interview.algorithm.p7dp.a1basic;

/**
 * @description: 62. 不同路径
 * @author：zhanyh
 * @date: 2023/5/4
 */
public class C07UniquePathsDP {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (!(i == m - 1 && j == n - 1)) {
                    memo[i][j] += i + 1 < m ? memo[i + 1][j] : 0;
                    memo[i][j] += j + 1 < n ? memo[i][j + 1] : 0;
                }
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new C07UniquePathsDP().uniquePaths(3, 7));
    }
}
