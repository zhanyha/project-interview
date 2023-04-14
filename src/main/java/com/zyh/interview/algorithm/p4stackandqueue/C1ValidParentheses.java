package com.zyh.interview.algorithm.p4stackandqueue;

import java.util.Stack;

/**
 * @description: 有效的括号
 * @author：zhanyh
 * @date: 2023/4/14
 * 输入：s = "([]{})"
 * 输出：true
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成 {[]}
 */
public class C1ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int pos = 0; pos < s.length(); pos++) {
            if (s.charAt(pos) == '(' || s.charAt(pos) == '[' || s.charAt(pos) == '{') {
                stk.push(s.charAt(pos));
            } else {
                if (s.charAt(pos) == ')') {
                    if (stk.isEmpty() || stk.pop() != '(')
                        return false;
                }

                if (s.charAt(pos) == '}') {
                    if (stk.isEmpty() || stk.pop() != '{')
                        return false;
                }
                if (s.charAt(pos) == ']') {
                    if (stk.isEmpty() || stk.pop() != '[')
                        return false;
                }
            }
        }

        return stk.isEmpty() ? true : false;
    }
}
