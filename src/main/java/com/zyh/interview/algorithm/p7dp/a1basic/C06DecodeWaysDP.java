package com.zyh.interview.algorithm.p7dp.a1basic;

/**
 * @description: 91. 解码方法
 * @author：zhanyh
 * @date: 2023/5/1
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
 */
public class C06DecodeWaysDP {
    public  int numDecodings(String s) {
        int len = s.length();
        int[] memo = new int[len];
        if(s.charAt(len - 1) == '0'){
            memo[len - 1] = 0;
        }else {
            memo[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if(s.charAt(i) == '0'){
                memo[i] += 0;
            }else {
                memo[i] += memo[i + 1];
                if (i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    if (i + 2 == s.length())
                        memo[i] += 1;
                    else{
                        memo[i] += memo[i + 2];
                    }
                }
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        System.out.println(new C06DecodeWaysDP().numDecodings("2302326"));
    }
}
