package com.zyh.interview.algorithm.p2find.a2map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanyh
 * @time 2023/3/14 8:47
 * a b a
 * dog dog dog
 */
public class C2WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] s1 = s.split(" ");
        if(pattern.length() != s1.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(s1[i])) {
                    return false;
                }
            } else {
                if(map.containsValue(s1[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), s1[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new C2WordPattern().wordPattern("abba", "dog cat cat dog"));
    }
}
