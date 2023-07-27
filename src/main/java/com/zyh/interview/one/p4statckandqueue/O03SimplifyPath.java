package com.zyh.interview.one.p4statckandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/simplify-path/
public class O03SimplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        List<String> list = new LinkedList<>();
        for (String str : strs) {

            if (str.trim().length() > 0 && !str.equals(".") && !str.equals("..")) {
                list.add(str.trim());
            } else if (str.equals("..")) {
                if (list.size() != 0)
                    list.remove(list.size() - 1);
            }
        }
        StringBuilder sbr = new StringBuilder();
        for (String s : list) {
            sbr.append("/").append(s);
        }
        return list.size() == 0 ? "/" : sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(new O03SimplifyPath().simplifyPath("/..."));
    }
}
