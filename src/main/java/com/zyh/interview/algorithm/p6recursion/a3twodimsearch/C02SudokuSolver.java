package com.zyh.interview.algorithm.p6recursion.a3twodimsearch;

/**
 * @description: 37. 解数独
 * @author：zhanyh
 * @date: 2023/4/29
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 */
public class C02SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
        return;
    }

    private boolean dfs(char[][] board, int x, int y) {
        if (x >= board.length) {

            return true;
        }
        if (board[x][y] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if(check(board, x, y, i)) {
                    board[x][y] = i;
                    if(dfs(board, x + (y + 1) / 9, (y + 1) % 9)) return true;
                    board[x][y] = '.';
                }
            }
        }else{
            if(dfs(board, x + (y + 1) / 9, (y + 1) % 9)) return true;
        }
        return false;
    }

    private boolean check(char[][] board, int x, int y, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num)
                return false;
        }
        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new C02SudokuSolver().solveSudoku(grid);
    }
}
