package com.zyh.interview.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash表的使用： 查找问题
 *
 * @description: 1072. 按列翻转得到最大值等行数
 * @author：zhanyh
 * @date: 2023/5/15
 * 给定m x n矩阵matrix。
 * 你可以从中选出任意数量的列并翻转其上的每个单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
 * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数。
 * 输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，前两行由相等的值组成。
 */
public class C003FlipColumnsEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sbr = new StringBuilder();
            if (matrix[i][0] == 1) {
                for (int j = 0; j < n; j++) {
                    sbr.append(1 - matrix[i][j]);
                }
            } else {
                for (int j = 0; j < n; j++) {
                    sbr.append(matrix[i][j]);
                }
            }
            String s = sbr.toString();
            if (!map.containsKey(s))
                map.put(s, 1);
            else
                map.put(s, map.get(s) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }
}
