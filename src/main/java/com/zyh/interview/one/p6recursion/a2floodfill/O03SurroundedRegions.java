package com.zyh.interview.one.p6recursion.a2floodfill;

/**
 * @description: 130. 被围绕的区域
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O03SurroundedRegions {
    private int m,n;
    private int[][] d = new int[][]{{-1,0}, {0,-1},{1,0},{0,1}};
    public void solve(char[][] grid) {
        this.m = grid.length;
        if(m == 0) return;
        this.n = grid[0].length;

        for(int x = 0; x < m; x++){
            for(int y=0; y < n;y ++){
                if(grid[x][y] == 'O' && (x == 0 || x == m-1 || y == 0 || y == n-1)){
                    dfs(grid, x, y);
                }
            }
        }

        for(int x = 0; x < m; x++){
            for(int y=0; y < n;y ++){
                if(grid[x][y] == '.'){
                    grid[x][y] = 'O';
                }
                else if(grid[x][y] =='O' && !(x == 0 || x == m-1 || y == 0 || y == n-1)){
                    grid[x][y] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] grid, int x, int y){

        for(int i = 0; i < 4; i++){
            int nextx = x + d[i][0];
            int nexty = y + d[i][1];
            if(inArea(nextx,nexty) && grid[nextx][nexty] == 'O'){
                grid[nextx][nexty] = '.';
                dfs(grid, nextx, nexty);
            }
        }

    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y >=0 && y < n;
    }
}
