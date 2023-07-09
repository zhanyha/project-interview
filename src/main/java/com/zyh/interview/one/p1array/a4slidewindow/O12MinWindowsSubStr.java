package com.zyh.interview.one.p1array.a4slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 */
// https://leetcode.cn/problems/minimum-window-substring/
public class O12MinWindowsSubStr {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray())
            need.put(ch, need.getOrDefault(ch, 0) + 1);

        int l = 0, r = 0;
        int valid = 0;
        int start = -1, len = s.length() + 1;
        while (r < s.length()) {
            char curCh = s.charAt(r);
            window.put(curCh, window.getOrDefault(curCh, 0) + 1);
            if (window.get(curCh).equals(need.get(curCh))) {
                valid++;
            }
            r++;
            while (valid == need.size()) {
                if(r - l < len) {
                    start = l;
                    len = r - l;
                }
                char delCh = s.charAt(l);
                if (window.get(delCh).equals(need.get(delCh)))
                    valid--;
                window.put(delCh, window.get(delCh) - 1);
                l++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new O12MinWindowsSubStr().minWindow(s, t));
    }
}
