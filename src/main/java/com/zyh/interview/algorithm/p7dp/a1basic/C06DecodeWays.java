package com.zyh.interview.algorithm.p7dp.a1basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 91. 解码方法
 * @author：zhanyh
 * @date: 2023/5/1
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
 */
public class C06DecodeWays {
    private Map<String, Integer> memo;
    public int numDecodings(String s) {
        memo = new HashMap<>();
        return numDecodingsCore(s, 0);
    }

    private int numDecodingsCore(String s, int index) {
        String tmp = s.substring(index);
        if(memo.containsKey(tmp)){
            return memo.get(tmp);
        }
        if(index == s.length())
            return 1;
        if(s.charAt(index) == '0')
            return 0;

        int res = 0;
        res += numDecodingsCore(s, index + 1);
        if(index + 2 <= s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26)
            res += numDecodingsCore(s, index + 2);
        memo.put(tmp, res);
        return memo.get(tmp);
    }

    public static void main(String[] args) {
        System.out.println(new C06DecodeWays().numDecodings("2302326"));
    }
}
