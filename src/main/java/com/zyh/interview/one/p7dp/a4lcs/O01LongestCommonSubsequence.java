package com.zyh.interview.one.p7dp.a4lcs;

/**
 * @description: 1143. 最长公共子序列
 * @author：zhanyh
 * @date: 2023/8/29
 */
public class O01LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = Math.max(dp[i][j], (i -1 >=0 && j - 1>=0 ? 1 + dp[i - 1][j - 1] : 1));

                dp[i][j] = Math.max(dp[i][j], i - 1 >= 0 ? dp[i - 1][j] : 0);
                dp[i][j] = Math.max(dp[i][j], j - 1 >= 0 ? dp[i][j - 1] : 0);

            }
        }
        return dp[m - 1][n - 1];
    }
}
