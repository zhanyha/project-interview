package com.zyh.interview.algorithm.p6recursion.a2floodfill;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/4/29
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 */
public class C02NumberOfIslands {
    private boolean[][] visited;
    private int[][] d = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    res += 1;
                    dfs(i, j, grid);
                }

            }
        }
        return res;

    }

    private void dfs(int x, int y, char[][] grid) {
        grid[x][y] = '0';
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                dfs(newx, newy, grid);
            }
        }
    }

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }
}
