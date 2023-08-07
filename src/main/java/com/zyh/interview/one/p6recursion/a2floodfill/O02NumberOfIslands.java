package com.zyh.interview.one.p6recursion.a2floodfill;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O02NumberOfIslands {
    private int m,n;
    private int[][] d = new int[][]{{-1,0}, {0,-1},{1,0},{0,1}};
    private boolean[][] visited;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        if(m == 0) return 0;
        this.n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;

        for(int x = 0; x < m; x++){
            for(int y=0; y < n;y ++){
                if(grid[x][y] == '1'){
                    res += 1;
                    dfs(grid, x, y);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y){

        for(int i = 0; i < 4; i++){
            int nextx = x + d[i][0];
            int nexty = y + d[i][1];
            if(inArea(nextx,nexty) && !visited[nextx][nexty] && grid[nextx][nexty] == '1'){
                visited[nextx][nexty] = true;
                grid[nextx][nexty] = '0';
                dfs(grid, nextx, nexty);
            }
        }

    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y >=0 && y < n;
    }
}
