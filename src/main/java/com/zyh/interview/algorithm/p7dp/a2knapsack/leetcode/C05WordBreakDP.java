package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 139. 单词拆分
 * @author：zhanyh
 * @date: 2023/5/11
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 */
public class C05WordBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0)
            return false;
        boolean[] memo = new boolean[s.length() + 1];
        memo[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if(s.substring(i, Math.min(i + word.length(), s.length())).equals(word)){
                    memo[i] = memo[i] || memo[i + word.length()];
                }
            }
        }
        return memo[0];
    }


    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("abc");
        l.add("b");
        l.add("cd");
        System.out.println(new C05WordBreakDP().wordBreak("abcd", l));
    }
}
