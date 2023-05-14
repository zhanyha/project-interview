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
public class C05WordBreak {
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0)
            return false;
        this.memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return wordBreakCore(s, wordDict, 0);
    }

    private boolean wordBreakCore(String s, List<String> wordDict, int index) {
        if(index == s.length())
            return true;
        if(index > s.length())
            return false;
        if(memo[index] != -1)
            return memo[index] == 1;
        for (String word : wordDict) {
            if(s.substring(index, Math.min(index + word.length(), s.length())).equals(word)){
                memo[index] = wordBreakCore(s, wordDict, index + word.length()) ? 1 : 0;
                if(memo[index] == 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("car");
        l.add("ca");
        l.add("rs");
        System.out.println(new C05WordBreak().wordBreak("cars", l));
    }
}
