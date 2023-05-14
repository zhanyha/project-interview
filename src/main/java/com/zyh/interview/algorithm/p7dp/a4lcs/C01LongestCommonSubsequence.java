package com.zyh.interview.algorithm.p7dp.a4lcs;

import java.util.Arrays;

/**
 * @description: 剑指 Offer II 095. 最长公共子序列
 * @author：zhanyh
 * @date: 2023/5/10
 * 给定两个字符串 text1 和 text2，
 * 返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
public class C01LongestCommonSubsequence {
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0)
            return 0;
        this.memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return LCSCore(text1, text2, 0, 0);
    }

    private int LCSCore(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length())
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        int res;
        if (text1.charAt(i) == text2.charAt(j))
            res = 1 + LCSCore(text1, text2, i + 1, j + 1);
        else
            res = Math.max(LCSCore(text1, text2, i + 1, j), LCSCore(text1, text2, i, j + 1));
        memo[i][j] = res;
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new C01LongestCommonSubsequence().longestCommonSubsequence("abcde", "ae"));
    }
}
