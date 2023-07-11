package com.zyh.interview.one.p2find.a1firststage;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/happy-number/
public class O01HappyNumber {
    public boolean isHappy(int n) {
        char[] num = (n + "").toCharArray();
        int res = 0;
        Set<Integer> set = new HashSet<>();
        while (res != 1) {
            res = 0;
            for (int i = 0; i < num.length; i++) {
                int a = num[i] - '0';
                res += a * a;
            }
            if (set.contains(res))
                return false;
            set.add(res);
            num = (res + "").toCharArray();
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new O01HappyNumber().isHappy(19));
    }
}
