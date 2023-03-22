package com.zyh.interview.algorithm.p2find.a2map;

import java.util.*;

/**
 * @author zhanyh
 * @time 2023/3/15 11:33
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 */
public class C4SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sbr = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sbr.append(entry.getKey());
            }
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(new C4SortCharactersByFrequency().frequencySort("Aabb"));
    }
}
