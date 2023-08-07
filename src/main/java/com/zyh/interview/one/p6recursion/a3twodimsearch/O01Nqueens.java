package com.zyh.interview.one.p6recursion.a3twodimsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: n皇后问题
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O01Nqueens {
    private List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n == 0) return res;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        solve(board, n, 0);
        return res;
    }

    private void solve(char[][] board, int n, int row){
        if(row >= n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sbr = new StringBuilder();
                for(int j = 0; j < n; j++){
                    sbr.append(board[i][j]);
                }
                list.add(sbr.toString());
            }
            res.add(list);
            return;
        }

        for(int i = 0; i < n; i++){
            if(check(board, row , i)){
                board[row][i] = 'Q';
                solve(board, n, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean check(char[][] board, int x, int y){
        int n = board.length;
        for(int i = 0; i < n; i++){
            if(board[x][i] == 'Q')
                return false;
        }

        for(int i = 0; i < n; i++){
            if(board[i][y] == 'Q')
                return false;
        }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                if(i - j == x - y && board[i][j] == 'Q'){
                    return false;
                }
                if(i + j == x + y && board[i][j] == 'Q'){
                    return false;
                }
            }

        return true;
    }
}
