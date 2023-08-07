package com.zyh.interview.one.p6recursion.a2floodfill;

/**
 * @description: 单词搜索
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O01WordSearch {
    int[][] dict = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        if(m == 0) return false;
        this.n = board[0].length;
        visited = new boolean[m][n];
        for(int x = 0 ; x < m; x ++){
            for(int y =0 ; y < n; y ++){
                if(dfs(board, word, 0, x , y ))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int x , int y ){
        if(index == word.length() - 1 && board[x][y] == word.charAt(index))
            return true;

        if(board[x][y] != word.charAt(index))
            return false;

        visited[x][y] = true;
        for(int d = 0; d < 4 ; d ++){
            int nextx = x + dict[d][0];
            int nexty = y + dict[d][1];
            if(inArea(nextx, nexty) && !visited[nextx][nexty])
                if(dfs(board, word, index + 1, nextx, nexty))
                    return true;
        }
        visited[x][y] = false;
        return false;
    }

    private boolean inArea(int x , int y){
        return x < m && x >=0 && y < n && y >= 0;
    }
}
