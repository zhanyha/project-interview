package com.zyh.interview.one.p1array.a1classic;

import lombok.var;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/8
 */
// https://leetcode.cn/problems/trapping-rain-water/
public class O05TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeftHeight = new int[n];
        for (int i = 0; i < n; i++) {
            maxLeftHeight[i] = i - 1 >= 0 ? Math.max(height[i], maxLeftHeight[i - 1]) : height[i];
        }

        int[] maxRightHeight = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRightHeight[i] = i+1 < n ? Math.max(height[i], maxRightHeight[i + 1]) : height[i];
        }

        int maxWater = 0;
        for (int i = 1; i <= n - 2; i++) {
            int water = Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
            if (water > 0)
                maxWater += water;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(new O05TrappingRainWater().trap(heights));
    }
}
