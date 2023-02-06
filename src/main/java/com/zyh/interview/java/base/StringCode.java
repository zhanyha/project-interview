/**
 * @author zhanyuhao
 * @time 2023/1/26 15:31
 */
package com.zyh.interview.java.base;

public class StringCode {
    public static void main(String[] args) {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing"; //在常量池中
        String str4 = str1 + str2;// 在堆中
        String str5 = "string"; //在常量池中
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false


        final String str11 = "str";
        final String str22 = "ing";
// 下面两个表达式其实是等价的
        String c = "str" + "ing";// 常量池中的对象
        String d = str11 + str22; // 常量池中的对象 final 修饰后，编译期间就能确定。
        System.out.println(c == d);// true
    }
}
