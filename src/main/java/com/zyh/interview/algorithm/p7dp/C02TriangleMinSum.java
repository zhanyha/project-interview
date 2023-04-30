package com.zyh.interview.algorithm.p7dp;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 120. 三角形最小路径和
 * @author：zhanyh
 * @date: 2023/4/30
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class C02TriangleMinSum {
    private int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < triangle.size(); i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return minimumTotalCore(triangle, 0, 0);
    }

    private int minimumTotalCore(List<List<Integer>> triangle, int level, int index) {
        if (memo[level][index] != Integer.MAX_VALUE)
            return memo[level][index];

        if (level == triangle.size() - 1)
            return triangle.get(level).get(index);

        memo[level][index] = triangle.get(level).get(index) + Math.min(minimumTotalCore(triangle, level + 1, index), minimumTotalCore(triangle, level + 1, index + 1));
        return memo[level][index];
    }
}
