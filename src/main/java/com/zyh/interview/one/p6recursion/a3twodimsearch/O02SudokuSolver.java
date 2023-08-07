package com.zyh.interview.one.p6recursion.a3twodimsearch;

/**
 * @description: 数独
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O02SudokuSolver {

    public void solveSudoku(char[][] board) {
        dfs(board, board.length, 0, 0);
        System.out.println(board);
    }


    private boolean dfs(char[][] board, int n, int x, int y) {
        if (x >= n) {
            return true;
        }


        if (board[x][y] == '.') {
            for (int i = 1; i < 10; i++) {
                if (check(board, x, y, i)) {
                    board[x][y] = (char) (i + '0');
                    if (dfs(board, n, x + ((y + 1) / 9), (y + 1) % 9))
                        return true;
                    board[x][y] = '.';
                }
            }
        } else {
            return dfs(board, n, x + ((y + 1) / 9), (y + 1) % 9);
        }
        return false;
    }

    private boolean check(char[][] board, int x, int y, int num) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[x][i] - '0' == num)
                return false;
        }

        for (int i = 0; i < n; i++) {
            if (board[i][y] - '0' == num)
                return false;
        }

        for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
                if (board[i][j] - '0' == num)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new O02SudokuSolver().solveSudoku(board);
    }
}
