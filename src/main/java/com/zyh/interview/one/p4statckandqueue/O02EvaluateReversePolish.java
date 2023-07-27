package com.zyh.interview.one.p4statckandqueue;

import java.util.Stack;

/**
 * @description: 150. 逆波兰表达式求值
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/evaluate-reverse-polish-notation/
public class O02EvaluateReversePolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (checkNum(tokens[i])) {
                stk.push(Integer.parseInt(tokens[i]));
            } else {
                Integer v1 = stk.pop();
                Integer v2 = stk.pop();
                int t = 0;
                switch (tokens[i]) {
                    case "+": {
                        t = v1 + v2;
                        break;
                    }
                    case "-": {
                        t = v1 - v2;
                        break;
                    }
                    case "*": {
                        t = v1 * v2;
                        break;
                    }
                    case "/": {
                        t = v1 / v2;
                        break;
                    }
                    default:
                        break;
                }
                stk.push(t);
            }
        }
        return stk.pop();
    }

    private boolean checkNum(String s) {
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/");
    }
}
