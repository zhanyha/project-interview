package com.zyh.interview.one.p1array.a4slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/find-all-anagrams-in-a-string/
public class O11Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : p.toCharArray())
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        int l = 0, r = 0; // [l, r)
        int valid = 0;
        while (r < s.length()) {
            char curCh = s.charAt(r);
            window.put(curCh, window.getOrDefault(curCh, 0) + 1);
            if (window.get(curCh).equals(need.get(curCh))) {
                valid++;
            }
            r++;
            while (r - l == p.length()) {
                if (valid == need.size()) {
                    res.add(l);
                }
                char delCh = s.charAt(l);
                if (window.get(delCh).equals(need.get(delCh))) {
                    valid--;
                }
                window.put(delCh, window.get(delCh) - 1);
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O11Anagrams().findAnagrams("cbaeeeebabacd", "abc"));
    }
}
