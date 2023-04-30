package com.zyh.interview.algorithm.p7dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 120. 三角形最小路径和
 * @author：zhanyh
 * @date: 2023/4/30
 */
public class C02TriangleMinSumDP {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        int[][] memo = new int[m][n];
        for (int i = 0; i < n; i++) {
            memo[m - 1][i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                memo[i][j] = triangle.get(i).get(j) + Math.min(memo[i + 1][j], memo[i + 1][j + 1]);
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        line.add(1);
        list.add(line);
        List<Integer> line1 = new ArrayList<>();
        line1.add(5);
        line1.add(3);
        list.add(line1);
        System.out.println(new C02TriangleMinSumDP().minimumTotal(list));
    }

}
