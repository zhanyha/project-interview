/**
 * @author zhanyuhao
 * @time 2023/2/7 14:43
 */
package com.zyh.interview.algorithm.p1arrays.a2对撞指针;

import com.zyh.interview.algorithm.p1arrays.a1经典.C02SortColor;

// https://leetcode.cn/problems/valid-palindrome/
// 验证回文串
public class C02Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !(s.charAt(l) >= 'a'&& s.charAt(l) <= 'z')
                    && !(s.charAt(l) >= '0'&& s.charAt(l) <= '1')){
                l++;
            }
            while(l < r && !(s.charAt(r) >= 'a'&& s.charAt(r) <= 'z')
                    && !(s.charAt(r) >= '0'&& s.charAt(r) <= '9')){
                r--;
            }
            if(s.charAt(l) != s.charAt(r))
                return false;
            else{
                l ++;
                r --;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new C02Palindrome().isPalindrome("9,8"));
    }
}
