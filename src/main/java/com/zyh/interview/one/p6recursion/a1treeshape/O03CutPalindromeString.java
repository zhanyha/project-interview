package com.zyh.interview.one.p6recursion.a1treeshape;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分割回文串
 * @author：zhanyh
 * @date: 2023/8/4
 */
public class O03CutPalindromeString {
    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        partitionCore(s, 0, new ArrayList<>());

        return res;
    }

    private void partitionCore(String s, int begin, List<String> list){
        if(begin == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = begin; i < s.length(); i++){
            String t = s.substring(begin, i + 1);
            if(check(t)){
                list.add(t);
                partitionCore(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean check(String s){
        StringBuilder sbr = new StringBuilder(s);
        return sbr.reverse().toString().equals(s);
    }


}
