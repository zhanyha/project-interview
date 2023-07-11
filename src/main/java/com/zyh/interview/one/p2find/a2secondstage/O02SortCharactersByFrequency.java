package com.zyh.interview.one.p2find.a2secondstage;

import java.util.*;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/sort-characters-by-frequency/
public class O02SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
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
        System.out.println(new O02SortCharactersByFrequency().frequencySort("tree"));
    }
}
