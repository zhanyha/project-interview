package com.zyh.interview.algorithm.p7dp.a4lcs;

import java.util.Arrays;

/**
 * @description: 剑指 Offer II 095. 最长公共子序列
 * @author：zhanyh
 * @date: 2023/5/10
 * DP解法
 */
public class C01LongestCommonSubsequenceDP {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j))
                    memo[i][j] = 1 + (i + 1 < m && j + 1< n ? memo[i + 1][j + 1] : 0);
                else
                    memo[i][j] = Math.max((i + 1 < m ? memo[i + 1][j] : 0),
                            (j + 1 < n ? memo[i][j + 1] : 0));
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new C01LongestCommonSubsequenceDP().longestCommonSubsequence("abcdet", "aegf"));
    }
}
