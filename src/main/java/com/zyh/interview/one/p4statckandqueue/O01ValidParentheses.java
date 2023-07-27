package com.zyh.interview.one.p4statckandqueue;

import java.util.Stack;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/27
 * [()]
 */
public class O01ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            } else {
                if (!stk.isEmpty()) {
                    Character pop = stk.pop();
                    if (ch == ')') {
                        if (pop == null || pop != '(')
                            return false;
                    } else if (ch == ']') {
                        if (pop == null || pop != '[')
                            return false;
                    } else if (ch == '}') {
                        if (pop == null || pop != '{')
                            return false;
                    }
                } else
                    return false;
            }
        }
        return stk.size() == 0;
    }

}
