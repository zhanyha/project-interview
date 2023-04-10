package com.zyh.interview.algorithm.p2find.a2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: :L447 回旋镖的数量
 * @author：zhanyh
 * @date: 2023/4/10
 * 给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的欧式距离相等
 * （需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * 所有点都 互不相同
 */
public class C11NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int dist = distance(points[i], points[j]);
                if(!map.containsKey(dist))
                    map.put(dist, 1);
                else
                    map.put(dist, map.get(dist) + 1);
            }
            Set<Integer> keys = map.keySet();
            for (Integer k: keys){
                Integer num = map.get(k);
                if(num >= 2){
                    res += num * (num - 1);
                }
            }
            map.clear();
        }
        return res;
    }

    private int distance(int[] point, int[] point1) {
        return (int) (Math.pow(point[0] - point1[0], 2) + Math.pow(point[1] - point1[1], 2));
    }
}
