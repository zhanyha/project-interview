package com.zyh.interview.one.p1array.a4slidewindow;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 * 输入: s = "pwcvawkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class O10LongestNoRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0; // [l,r]
        int[] freq = new int[256];
        int res = -1;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (freq[c] == 0) {
                freq[c]++;
                res = Math.max(res, r - l + 1);
                r++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O10LongestNoRepeatChar().lengthOfLongestSubstring("baab"));
    }
}
