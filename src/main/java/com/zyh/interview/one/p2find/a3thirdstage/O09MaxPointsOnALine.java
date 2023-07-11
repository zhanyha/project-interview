package com.zyh.interview.one.p2find.a3thirdstage;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/max-points-on-a-line/
public class O09MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Double k = getK(points, i, j);
                map.put(k, map.getOrDefault(k, 0) + 1);
            }

            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                if (entry.getValue() > res) {
                    res = entry.getValue();
                }
            }
            map.clear();
        }
        return res + 1;
    }

    private Double getK(int[][] points, int i, int j) {
        if (points[i][1] - points[j][1] == 0)
            return 0d;
        if (points[i][0] - points[j][0] != 0)
            return (double) (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
        return Double.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(new O09MaxPointsOnALine().maxPoints(new int[][]{{1, 1}, {1, 4}, {3, 2}, {5, 3}, {4, 1}, {2, 3}}));
    }
}
