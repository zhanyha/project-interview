package com.zyh.interview.one.p7dp.a1basic;

/**
 * @description: 91. 解码方法
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class O06DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1;
        if(s.charAt(n-1) != '0')
            memo[n-1] = 1;
        else
            memo[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) != '0')
                memo[i] += memo[i + 1];
            if(!s.substring(i, i+2).startsWith("0") && Integer.parseInt(s.substring(i,i+2)) <= 26)
                memo[i] += memo[i + 2];
        }

        return memo[0];
    }
}
