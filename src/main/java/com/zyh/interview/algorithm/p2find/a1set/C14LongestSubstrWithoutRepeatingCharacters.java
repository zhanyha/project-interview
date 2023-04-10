package com.zyh.interview.algorithm.p2find.a1set;

/**
 * @description: 无重复字符的最长子串
 * @author：zhanyh
 * @date: 2023/4/10
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 */
public class C14LongestSubstrWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0; // [l, r)
        int[] freq = new int[256];
        int res = -1;
        while (r < s.length()) {
            if (freq[s.charAt(r)] == 0) {
                freq[s.charAt(r)]++;
                r++;
            } else {
                res = Math.max(res, r - l);
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return res == -1 ? r - l : Math.max(res, r - l);
    }

    public static void main(String[] args) {
        System.out.println(new C14LongestSubstrWithoutRepeatingCharacters().lengthOfLongestSubstring("aad"));
    }
}
