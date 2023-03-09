/**
 * @author zhanyuhao
 * @time 2023/2/7 15:00
 */
package com.zyh.interview.algorithm.p1arrays.a3滑动窗口;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

/**
 * 输入: s = "pwwkew"
 * 输出: 3
 */
public class C02LongestNoRepeatChar {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1; //s [l, r] 无重复字串
        int[] freq = new int[256];
        int res = 0;
        while (l < s.length()) {
            if (freq[s.charAt(++r)] == 0) {
                res += 1;
            }
            freq[s.charAt(++r)] += 1;

        }
        return 0;
    }
}
