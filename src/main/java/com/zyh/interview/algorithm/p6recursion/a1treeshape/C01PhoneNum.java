package com.zyh.interview.algorithm.p6recursion.a1treeshape;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 电话号码的字母组合
 * @author：zhanyh
 * @date: 2023/4/26
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class C01PhoneNum {
    private List<String> res;
    private String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        res = new ArrayList<>();
        combinations(digits, 0, "");
        return res;
    }

    private void combinations(String digits, int index, String s) {
        if(index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combinations(digits, index + 1, s + letters.charAt(i));
        }
    }
}
