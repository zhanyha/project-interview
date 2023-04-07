package com.zyh.interview.algorithm.p2find.a1set;

import java.util.HashSet;

/**
 * @author zhanyh
 * @time 2023/3/13 10:46
 */
public class C1HappyNumber {

    public boolean isHappy(int n) {
        String s = String.valueOf(n);
        HashSet<String> set = new HashSet<>();
        set.add(s);
        while (true) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += ( s.charAt(i) - '0' )*( s.charAt(i) - '0');
            }
            if(sum == 1) {
                return true;
            }
            s = String.valueOf(sum);
            if(set.contains(s)) {
                return false;
            }
            set.add(s);
        }
    }

    public static void main(String[] args) {
        System.out.println(new C1HappyNumber().isHappy(2));
    }

}
