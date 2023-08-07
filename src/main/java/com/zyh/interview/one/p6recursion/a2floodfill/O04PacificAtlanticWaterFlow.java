package com.zyh.interview.one.p6recursion.a2floodfill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 417. 太平洋大西洋水流问题
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O04PacificAtlanticWaterFlow {
    private int m,n;
    private int[][] d = new int[][]{{-1,0}, {0,-1},{1,0},{0,1}};
    private boolean[][] visited;
    private boolean pacific;
    private boolean altantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        this.m = heights.length;
        if(m == 0) return res;
        this.n = heights[0].length;
        visited = new boolean[m][n];

        List<Integer> list = new ArrayList<>();
        for(int x = 0; x < m; x++){
            for(int y=0; y < n;y ++){
                dfs(heights, x, y);
                if(pacific && altantic){
                    list.add(x);
                    list.add(y);
                    res.add(new ArrayList<>(list));
                    list.clear();
                }
                pacific = false;
                altantic = false;
                for(int k=0;k<m;k++){
                    Arrays.fill(visited[k], false);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int x, int y){

        for(int i = 0; i < 4; i++){
            int nextx = x + d[i][0];
            int nexty = y + d[i][1];
            if(!(pacific && altantic) &
                    inArea(nextx, nexty) && !visited[nextx][nexty] && heights[nextx][nexty] <= heights[x][y]){
                visited[nextx][nexty] = true;
                dfs(heights, nextx, nexty);
                visited[nextx][nexty] = false;
            }
        }
    }

    private boolean inArea(int x, int y){
        if(x < 0 || y < 0)
            pacific = true;
        if(x >= m && y >= n)
            altantic = true;
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        System.out.println(new O04PacificAtlanticWaterFlow().pacificAtlantic(heights));
    }
}
