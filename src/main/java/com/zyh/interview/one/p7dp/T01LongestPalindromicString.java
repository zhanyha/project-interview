package com.zyh.interview.one.p7dp;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/12
 */

//5  https://leetcode.cn/problems/longest-palindromic-substring/
public class T01LongestPalindromicString {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        int maxLen = 1;
        for (int i = 1; i < s.length() - 1; i++) {
            int[] res1 = getPalindromeLen(s, i, i);
            int[] res2 = getPalindromeLen(s, i, i + 1);
            int len1 = res1[1] - res1[0] + 1;
            int len2 = res2[1] - res2[0] + 1;
            if (len1 > len2) {
                if (len1 > maxLen) {
                    maxLen = len1;
                    left = res1[0];
                    right = res1[1];
                }
            } else {
                if (len2 > maxLen) {
                    maxLen = len2;
                    left = res2[0];
                    right = res2[1];
                }
            }

        }
        return s.substring(left, right + 1);
    }

    private int[] getPalindromeLen(String s, int l, int r) {
        while (l >= 0 & r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[]{l + 1, r - 1};
    }

    public static void main(String[] args) {
        System.out.println(new T01LongestPalindromicString().longestPalindrome("abbc"));
    }
}
