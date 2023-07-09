package com.zyh.interview.one.p1array.a1classic;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/8
 */
// https://leetcode.cn/problems/trapping-rain-water-ii/
public class O06TrappingRainWaterII {
    public int trap(int[][] height) {
        int m = height.length;
        int n = height[0].length;
        int[][] maxLeftHeight = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLeftHeight[i][j] = j - 1 >= 0 ? Math.max(height[i][j], maxLeftHeight[i][j - 1]) : height[i][j];
            }
        }

        int[][] maxRightHeight = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                maxRightHeight[i][j] = j + 1 < n ? Math.max(height[i][j], maxRightHeight[i][j + 1]) : height[i][j];
            }
        }

        int[][] maxUpHeight = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxUpHeight[i][j] = i - 1 >= 0 ? Math.max(height[i][j], maxUpHeight[i - 1][j]) : height[i][j];
            }
        }

        int[][] maxDownHeight = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                maxDownHeight[i][j] = i + 1 < m ? Math.max(height[i][j], maxDownHeight[i + 1][j]) : height[i][j];
            }
        }

        for (int i = 1; i <= m - 2; i++) {
            for (int j = 1; j <= n - 2; j++) {
                maxLeftHeight[i][j] = min4(maxLeftHeight[i][j], maxRightHeight[i][j], maxUpHeight[i][j], maxDownHeight[i][j]);
                maxRightHeight[i][j] = min4(maxLeftHeight[i][j], maxRightHeight[i][j], maxUpHeight[i][j], maxDownHeight[i][j]);
                maxUpHeight[i][j] = min4(maxLeftHeight[i][j], maxRightHeight[i][j], maxUpHeight[i][j], maxDownHeight[i][j]);
                maxDownHeight[i][j] = min4(maxLeftHeight[i][j], maxRightHeight[i][j], maxUpHeight[i][j], maxDownHeight[i][j]);
            }
        }

        int maxWater = 0;
        for (int i = 1; i <= m - 2; i++) {
            for (int j = 1; j <= n - 2; j++) {
                int water = min4(maxLeftHeight[i][j], maxRightHeight[i][j], maxUpHeight[i][j], maxDownHeight[i][j]) - height[i][j];
                if (water > 0)
                    maxWater += water;
            }
        }
        return maxWater;
    }

    public int min4(int a, int b, int c, int d) {
        return Math.min(Math.min(Math.min(a, b), c), d);
    }

    public static void main(String[] args) {
//        int[][] heights = new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
        int[][] heights = new int[][]{{12, 13, 1, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}};
        System.out.println(new O06TrappingRainWaterII().trap(heights));
    }
}
