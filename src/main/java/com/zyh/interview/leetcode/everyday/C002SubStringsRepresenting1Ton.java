package com.zyh.interview.leetcode.everyday;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/11
 */
public class C002SubStringsRepresenting1Ton {
    public boolean queryString(String s, int n) {
        for (int num = 0; num <= n; num++) {
            String str = Integer.toString(num, 2);
            if (!s.contains(str))
                return false;
        }
        return true;
    }

}
