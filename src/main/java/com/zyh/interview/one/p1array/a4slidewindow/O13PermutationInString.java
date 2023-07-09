package com.zyh.interview.one.p1array.a4slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 * 输入：s1 = "ab" s2 = "eidbocbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 */
// https://leetcode.cn/problems/permutation-in-string/
public class O13PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : s1.toCharArray())
            need.put(ch, need.getOrDefault(ch, 0) + 1);

        int l = 0, r = 0;
        int valid = 0;

        while (r < s2.length()) {
            char curCh = s2.charAt(r);
            window.put(curCh, window.getOrDefault(curCh, 0) + 1);
            if (window.get(curCh).equals(need.get(curCh))) {
                valid++;
                if (valid == need.size())
                    return true;
            }
            r++;
            while (r - l == s1.length()){
                char delCh = s2.charAt(l);
                if (window.get(delCh).equals(need.get(delCh))) {
                    valid--;
                }
                window.put(delCh, window.get(delCh) - 1);
                l++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new O13PermutationInString().checkInclusion("ab", "00oe3afavbcafd"));
    }
}
