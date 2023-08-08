package com.zyh.interview.one.p7dp.a1basic;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 120. 三角形最小路径和
 * @author：zhanyh
 * @date: 2023/8/9
 */
public class O02TriangleMinSum {
    private int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        memo = new int[m][n];
        for(int i = 0; i< m; i++)
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        return f(triangle, 0, 0);
    }

    private int minimumTotalDP(List<List<Integer>> triangle){
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] memo = new int[m][n];

        for(int i = 0; i < n; i++){
            memo[m - 1][i] = triangle.get(m - 1).get(i);
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j ++){
                memo[i][j] = triangle.get(i).get(j) + Math.min(memo[i + 1][j] , memo[i + 1][j + 1]);
            }
        }

        return memo[0][0];
    }

    public int f(List<List<Integer>> triangle, int i, int j) {
        if(i == triangle.size())
            return 0;
        if(memo[i][j] != Integer.MIN_VALUE)
            return memo[i][j];

        memo[i][j] =  Math.min(
                triangle.get(i).get(j) + f(triangle, i + 1, j),
                triangle.get(i).get(j) + f(triangle, i + 1, j + 1)
        );
        return memo[i][j];
    }
}
