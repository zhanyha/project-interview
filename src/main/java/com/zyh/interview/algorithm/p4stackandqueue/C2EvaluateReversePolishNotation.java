package com.zyh.interview.algorithm.p4stackandqueue;

import java.util.Stack;

/**
 * @description: 逆波兰表达式求值
 * @author：zhanyh
 * @date: 2023/4/14
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 1 <= tokens.length <= 104
 * tokens[i]是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 */
public class C2EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        String token;
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i];
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stk.push(tokens[i]);
            } else {
                assert stk.size() >= 2;
                String val2 = stk.pop();
                String val1 = stk.pop();
                switch (token) {
                    case "+":
                        stk.push(String.valueOf(Integer.parseInt(val1) + Integer.parseInt(val2)));
                        break;
                    case "-":
                        stk.push(String.valueOf(Integer.parseInt(val1) - Integer.parseInt(val2)));
                        break;
                    case "*":
                        stk.push(String.valueOf(Integer.parseInt(val1) * Integer.parseInt(val2)));
                        break;
                    case "/":
                        stk.push(String.valueOf(Integer.parseInt(val1) / Integer.parseInt(val2)));
                        break;
                    default:
                        break;
                }
            }
        }
        return Integer.parseInt(stk.pop());
    }
}
