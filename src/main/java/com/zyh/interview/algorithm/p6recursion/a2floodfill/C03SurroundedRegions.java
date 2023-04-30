package com.zyh.interview.algorithm.p6recursion.a2floodfill;

/**
 * @description: 130. 被围绕的区域
 * @author：zhanyh
 * @date: 2023/4/29
 */
public class C03SurroundedRegions {
    private int[][] d = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int m;
    private int n;
    private boolean[][] visited;

    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        this.m = board.length;
        this.n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O')
                        dfs1(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    continue;
                }
                if (board[i][j] == 'O' && !visited[i][j])
                    dfs2(board, i, j);
            }
        }
    }

    private void dfs2(char[][] board, int x, int y) {
        board[x][y] = 'X';
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && board[newx][newy] == 'O')
                dfs2(board, newx, newy);
        }
    }

    private void dfs1(char[][] board, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && board[newx][newy] == 'O')
                dfs1(board, newx, newy);
        }
    }

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }
}
