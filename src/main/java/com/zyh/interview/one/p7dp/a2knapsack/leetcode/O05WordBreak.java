package com.zyh.interview.one.p7dp.a2knapsack.leetcode;

import java.util.List;
import java.util.Map;

/**
 * @description: 139. 单词拆分
 * @author：zhanyh
 * @date: 2023/8/26
 */
public class O05WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1; i <= n; i ++){
            for(String word : wordDict){
                int len = word.length();
                if(i >= len){
                    if(s.substring(i - len, i).equals(word))
                        dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
    private Map<String, Boolean> memo;

    public boolean wordBreakCore(String s, List<String> wordDict) {
        if(s.equals(""))
            return true;

        if(memo.get(s) != null)
            return memo.get(s);

        for(String word : wordDict){
            if(s.length() - word.length() >= 0){
                String subs = s.substring(s.length() - word.length(), s.length());
                if(subs.equals(word)){
                    String next = s.substring(0, s.length()- word.length());
                    if(wordBreakCore(next, wordDict )){
                        memo.put(next, true);
                        return true;
                    }
                }
            }
        }
        memo.put(s, false);
        return false;
    }


}
