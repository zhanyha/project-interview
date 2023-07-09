package com.zyh.interview.one.p1array.a3collidingpointer;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/container-with-most-water/
public class O02MostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }
}
