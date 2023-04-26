package com.zyh.interview.algorithm.p6recursion.a1treeshape;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/4/26
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 1 <= s.length <= 20
 * s 仅由数字组成
 */
public class C02RestoreIpAddresses {
    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length() < 4) return res;
        List<Integer> indexes = new ArrayList<>();
        restoreCore(s, 1, indexes);
        return res;
    }

    private void restoreCore(String s, int start, List<Integer> indexes) {
        if (indexes.size() == 3) {
            String ip = s.substring(0, indexes.get(0)) + "." +
                    s.substring(indexes.get(0), indexes.get(1)) + "." +
                    s.substring(indexes.get(1), indexes.get(2)) + "." +
                    s.substring(indexes.get(2));
            res.add(ip);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (check(s, indexes, i)) {
                indexes.add(i);
                restoreCore(s, i + 1, indexes);
                indexes.remove(indexes.size() - 1);
            }
        }

    }

    private boolean check(String s, List<Integer> indexes, int cur) {
        int pre = 0;
        if (indexes.size() != 0)
            pre = indexes.get(indexes.size() - 1);
        String substring = s.substring(pre, cur);
        if (substring.length() != 1 && substring.startsWith("0"))
            return false;
        if(indexes.size() == 2) {
            if (s.substring(cur).length() != 1 && s.substring(cur).startsWith("0"))
                return false;
            if(s.substring(cur).length() > 4 || Long.parseLong(s.substring(cur)) > 255)
                return false;
        }
        return substring.length() <= 3 && Long.parseLong(substring) <= 255;
    }
}
