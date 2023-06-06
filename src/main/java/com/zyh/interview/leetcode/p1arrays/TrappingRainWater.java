package com.zyh.interview.leetcode.p1arrays;

/**
 * @description: 42. 接雨水
 * @author：zhanyh
 * @date: 2023/5/16
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int total = 0;
        int n = height.length;
        int[] leftMaxHeight = new int[n];
        int[] rightMaxHeight = new int[n];
        for (int i = 1; i < n; i++) {
            leftMaxHeight[i] = Math.max(height[i-1], leftMaxHeight[i-1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(height[i+1], rightMaxHeight[i+1]);
        }

        for (int i = 1; i < n; i++) {
            int min = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if(min - height[i] > 0)
                total += min - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] heights = {4,2,3};
        System.out.println(new TrappingRainWater().trap(heights));
    }
}
