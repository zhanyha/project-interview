/**
 * @author zhanyuhao
 * @time 2023/2/7 14:46
 */
package com.zyh.interview.algorithm.p1arrays.a2对撞指针;

// https://leetcode.cn/problems/container-with-most-water/

import sun.font.CoreMetrics;

/**
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 = abs(1-8) * min(8, 7)
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 */
public class C03MostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area,(r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new C03MostWater().maxArea(nums));
    }
}
