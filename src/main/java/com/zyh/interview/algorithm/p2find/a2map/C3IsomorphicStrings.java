package com.zyh.interview.algorithm.p2find.a2map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanyh
 * @time 2023/3/15 11:22
 */
// s = 'dog' t = 'aaa'
//输入：s = "paper", t = "title"
//输出：true
public class C3IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                 if(map.get(s.charAt(i)) != t.charAt(i)) {
                     return false;
                 }
            }
        }
        return true;
    }

}
