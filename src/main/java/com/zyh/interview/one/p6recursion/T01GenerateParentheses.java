package com.zyh.interview.one.p6recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/12
 */
// 22 https://leetcode.cn/problems/generate-parentheses/
public class T01GenerateParentheses {

    private final List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        parenthesisCore("", n, n);
        return res;
    }

    private void parenthesisCore(String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left >= 0)
            parenthesisCore(s + "(", left - 1, right);
        if (right > left) {
            parenthesisCore(s + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new T01GenerateParentheses().generateParenthesis(4));
    }
}
