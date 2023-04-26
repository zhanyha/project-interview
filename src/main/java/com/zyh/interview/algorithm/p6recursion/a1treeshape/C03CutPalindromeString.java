package com.zyh.interview.algorithm.p6recursion.a1treeshape;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分割回文串
 * @author：zhanyh
 * @date: 2023/4/26
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。
 * 返回 s 所有可能的分割方案。
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class C03CutPalindromeString {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 0) return res;
        List<Integer> list = new ArrayList<>();
        partitionCore(s, 0, 0, list);
        return res;
    }

    private void partitionCore(String s, int start, int index, List<Integer> list) {
        if (index >= s.length()) {
            boolean flag;
            List<String> line = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                String substring;
                if (i == 0) {
                    substring = s.substring(0, list.get(i) + 1);
                    StringBuilder sbr = new StringBuilder(substring);
                    flag = sbr.reverse().toString().equals(substring);
                } else {
                    substring = s.substring(list.get(i - 1) + 1, list.get(i) + 1);
                    StringBuilder sbr = new StringBuilder(substring);
                    flag = sbr.reverse().toString().equals(substring);
                }
                line.add(substring);
                if (!flag)
                    return;
            }
            res.add(line);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            list.add(i);
            partitionCore(s, i + 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
