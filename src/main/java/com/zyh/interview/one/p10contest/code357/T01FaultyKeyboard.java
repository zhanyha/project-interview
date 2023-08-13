package com.zyh.interview.one.p10contest.code357;

/**
 * @description: 2810. 故障键盘
 * @author：zhanyh
 * @date: 2023/8/10
 */
public class T01FaultyKeyboard {
    public String finalString(String s) {
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'i'){
                sbr.reverse();
            }else{
                sbr.append(s.charAt(i));
            }
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T01FaultyKeyboard().finalString("string"));
    }
}
