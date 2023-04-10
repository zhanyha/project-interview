package com.zyh.interview.algorithm.p2find.a2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @description: max-points-on-a-line
 * @author：zhanyh
 * @date: 2023/4/10
 * 给你一个数组 points ，其中 points[i] = [xi, yi]
 * 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * [[3,2],[4,1],[2,3],[1,4]] 直线方程 ： y = -x + 5;
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * points 中的所有点 互不相同
 */
public class C12MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Double k = getK(points[i], points[j]);
                if (!map.containsKey(k)) {
                    map.put(k, 1);
                } else {
                    map.put(k, map.get(k) + 1);
                }
            }
            Set<Map.Entry<Double, Integer>> entries = map.entrySet();
            for (Map.Entry<Double, Integer> entry : entries) {
                if (entry.getValue() > count) {
                    count = entry.getValue();
                }
            }
            map.clear();
        }
        return count + 1;
    }

    private Double getK(int[] point, int[] point1) {
        if (point[0] - point1[0] == 0)
            return (double) 0x7fffffff;
        if(point[1] - point1[1] ==  0)
            return 0.0D;
        return (double) (point[1] - point1[1]) / (double) (point[0] - point1[0]);
    }
}
