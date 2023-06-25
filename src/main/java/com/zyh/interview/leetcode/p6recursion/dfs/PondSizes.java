package com.zyh.interview.leetcode.p6recursion.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 面试题 16.19. 水域大小
 * @author：zhanyh
 * @date: 2023/6/22
 */
public class PondSizes {
    private List<Integer> res = new ArrayList<>();
    private int m;
    private int n;

    private int cnt = 0;
    private boolean[][] visited;

    public int[] pondSizes(int[][] land) {
        m = land.length;
        assert land.length >= 1;
        n = land[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    cnt = 0;
                    pondSizesCore(land, i, j);
                    res.add(cnt);
                }
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }

    private void pondSizesCore(int[][] land, int x, int y) {
        cnt++;
        land[x][y] = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                int nextx = x + i;
                int nexty = y + j;
                if (inArea(nextx, nexty) && !visited[nextx][nexty] && land[nextx][nexty] == 0) {
                    pondSizesCore(land, nextx, nexty);
                }
            }
        }
    }

    private boolean inArea(int nextx, int nexty) {
        return nextx >= 0 && nextx < m && nexty >= 0 && nexty < n;
    }
}
