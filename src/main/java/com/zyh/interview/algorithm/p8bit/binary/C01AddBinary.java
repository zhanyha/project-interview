package com.zyh.interview.algorithm.p8bit.binary;

import java.math.BigInteger;

/**
 * @description: 二进制求和
 * @author：zhanyh
 * @date: 2023/5/27
 * 输入:a = "11", b = "1"
 * 输出："100"
 */
public class C01AddBinary {
    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        a = String.format("%0" + n + "d", new BigInteger(a));
        b = String.format("%0" + n + "d", new BigInteger(b));
        int c = 0;
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        StringBuilder sbr = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sbr.append(((achars[i]-'0') +( bchars[i] - '0') + c) % 2);
            c = ((achars[i]-'0') +( bchars[i] - '0') + c) / 2;
        }
        if (c == 1)
            sbr.append(c);

        return sbr.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new C01AddBinary().addBinary("11", "1"));
    }
}
