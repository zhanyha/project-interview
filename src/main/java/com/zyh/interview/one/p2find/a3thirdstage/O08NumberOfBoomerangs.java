package com.zyh.interview.one.p2find.a3thirdstage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
public class O08NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> distMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dist = getDistance(points, i, j);
                distMap.put(dist, distMap.getOrDefault(dist, 0) + 1);
            }
            Set<Map.Entry<Integer, Integer>> entries = distMap.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                Integer n = entry.getValue();
                if (n >= 2) {
                    res += n * (n - 1);
                }
            }
            distMap.clear();
        }
        return res;
    }

    private int getDistance(int[][] points, int i, int j) {
        return (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
    }

}
