package com.zyh.interview.algorithm.p6recursion.a3twodimsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 51. N 皇后
 * @author：zhanyh
 * @date: 2023/4/29
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 */
public class C01Nqueens {
    private List<List<String>> res;
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] grids = new char[n][n];
        for (int i = 0; i < grids.length; i++) {
            Arrays.fill(grids[i], '.');
        }
        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        dfs(grids, 0);
        return res;
    }

    private void dfs(char[][] grids, int row) {
        if (row >= grids.length) {
            List<String> line = new ArrayList<>();
            for (int i = 0; i < grids.length; i++) {
                String str = "";
                for (int j = 0; j < grids[0].length; j++) {
                    str += grids[i][j];
                }
                line.add(str);
            }
            res.add(line);
            return;
        }

        for (int i = 0; i < grids[0].length; i++) {
            if (!col[i] && !diag1[row + i] && !diag2[row - i + grids[0].length - 1]) {
                col[i] = true;
                diag1[row + i] = true;
                diag2[row - i + grids[0].length - 1] = true;
                grids[row][i] = 'Q';
                dfs(grids, row + 1);
                grids[row][i] = '.';
                col[i] = false;
                diag1[row + i] = false;
                diag2[row - i + grids[0].length - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new C01Nqueens().solveNQueens(3));
    }
}
