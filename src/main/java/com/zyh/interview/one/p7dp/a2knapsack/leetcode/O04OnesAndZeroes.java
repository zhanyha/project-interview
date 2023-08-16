package com.zyh.interview.one.p7dp.a2knapsack.leetcode;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/15
 */
public class O04OnesAndZeroes {
    public int findMaxForm(String[] strs, int M, int N) {
        int len = strs.length;
        int[] zeros = new int[len];
        int[] ones = new int[len];
        for(int j= 0; j < strs.length; j ++){
            int one = 0, zero = 0;
            for(int i = 0; i < strs[j].length(); i ++){
                if(strs[j].charAt(i) == '0')
                    zero ++;
                else
                    one++;
            }
            zeros[j] = zero;
            ones[j] = one;
        }

        int[][][] memo = new int[len][M + 1][N + 1];
        for(int m = 0 ; m <= M; m ++){
            for(int n = 0; n <= N; n ++){
                if(m >= zeros[0] && n >= ones[0])
                    memo[0][m][n] = 1;
            }
        }

        for(int i = 1; i < len; i ++){
            for(int m = 0 ; m <= M; m ++){
                for(int n = 0; n <= N; n ++){
                    memo[i][m][n] = memo[i - 1][m][n];
                    if(m >= zeros[i] && n >= ones[i])
                        memo[i][m][n] =Math.max(memo[i][m][n], 1 + memo[i-1][m - zeros[i]][n - ones[i]]);
                }
            }
        }

        return memo[len - 1][M][N];
    }
}
