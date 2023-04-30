package com.zyh.interview.algorithm.p6recursion.a2floodfill;

/**
 * @description: 79. 单词搜索
 * @author：zhanyh
 * @date: 2023/4/29
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 输入：board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class C01wordSearch {

    private int[][] d = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int m;
    private int n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        this.m = board.length;
        this.n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (searchWord(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean searchWord(int x, int y, char[][] board, String word, int index) {
        visited[x][y] = true;
        if (index >= word.length())
            return true;
        if (board[x][y] != word.charAt(index))
            return false;

        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && !visited[newx][newy]) {
                if (searchWord(newx, newy, board, word, index + 1))
                    return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }

    public static void main(String[] args) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                System.out.println(i + "," + j);
            }
        }
    }

}
