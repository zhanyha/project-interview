package com.zyh.interview.one.p6recursion.a1treeshape;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 17. 电话号码的字母组合
 * @author：zhanyh
 * @date: 2023/8/4
 */
//  https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
public class O01PhoneNum {

    private String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };
    private List<String> res ;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0) return res;
        letterCombinations(digits, 0 , "");

        return res;
    }

    private void letterCombinations(String digits, int index , String s){

        if(index == digits.length()){
            res.add(s);
            return;
        }


        for(int i = 0; i < map[digits.charAt(index) - '0'].length(); i++)
            letterCombinations(digits, index + 1, s + map[digits.charAt(index) - '0'].charAt(i) );
    }
}
