package com.zyh.interview.algorithm.p2find.a2map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 字母异位词分组
 * @author：zhanyh
 * @date: 2023/4/10
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class C10GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sortedStr = sortString(strs[i]);
            if(!map.containsKey(sortedStr)){
                List<String> line = new ArrayList<>();
                line.add(strs[i]);
                res.add(line);
                map.put(sortedStr, res.size() - 1);
            }else{
                Integer idx = map.get(sortedStr);
                res.get(idx).add(strs[i]);
            }
        }
        return res;
    }

    private String sortString(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a'] += 1;
        }
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != 0){
                for (int j = 0; j < freq[i]; j++) {
                    sbr.append((char) (i + 'a'));
                }
            }
        }
        return sbr.toString();
    }
}
