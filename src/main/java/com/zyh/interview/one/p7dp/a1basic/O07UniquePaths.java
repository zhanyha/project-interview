package com.zyh.interview.one.p7dp.a1basic;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class O07UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[m - 1][n - 1] = 1;

        for(int i = m - 1; i >= 0 ; i--){
            for(int j = n-1; j >=0; j--){
                if(i == m - 1 && j == n - 1) continue;

                memo[i][j] += i + 1 >= m ? 0 : memo[i + 1][j];
                memo[i][j] += j + 1 >= n ? 0 : memo[i][j + 1];
            }
        }

        return memo[0][0];
    }
}
