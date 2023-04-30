package com.zyh.interview.algorithm.p6recursion.a2floodfill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 417. 太平洋大西洋水流问题
 * @author：zhanyh
 * @date: 2023/4/29
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 输入: heights = [
 * [1,2,2,3,5],
 * [3,2,3,4,4],
 * [2,4,5,3,1],
 * [6,7,1,4,5],
 * [5,1,1,2,4]
 * ]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * [
 * [1, 2, 3, 4, 5],
 * [16,17,18,19,6],
 * [15,24,25,20,7],
 * [14,23,22,21,8],
 * [13,12,11,10,9]
 * ]
 */
public class C04PacificAtlanticWaterFlow {
    private int[][] d = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int m;
    private int n;
    private boolean[][] visited;

    private boolean pacific = false;
    private boolean atlantic = false;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights.length == 0)
            return res;
        this.m = heights.length;
        this.n = heights[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(heights, i, j);
                for (int k = 0; k < visited.length; k++) {
                    Arrays.fill(visited[k], false);
                }
                if (pacific && atlantic) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
                pacific = false;
                atlantic = false;
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int x, int y) {
        if(pacific && atlantic)
            return;
        if(x == 0 || y == 0){
            pacific = true;
        }
        if (x == m-1 || y == n-1) {
            atlantic = true;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && heights[newx][newy] <= heights[x][y] && !visited[newx][newy]) {
                dfs(heights, newx, newy);
            }
        }
        visited[x][y] = false;
    }

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }
}
