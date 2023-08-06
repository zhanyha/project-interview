package com.zyh.interview.one.p6recursion.a1treeshape;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/4
 */
public class O02RestoreIpAddresses {
    private List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        restoreIpAddressesCore(s, 0, list);
        return res;
    }

    public void restoreIpAddressesCore(String s, int start, List<Integer> list){
        if(list.size() == 3){
            if(check(s, list.get(2), s.length())){
                String ip = genIP(s, list);
                res.add(ip);
            }
            return;
        }
        for(int i = start; i < Math.min(start + 3, s.length() - 1) ; i ++){
            if(check(s, start, i + 1)){
                list.add(i + 1);
                restoreIpAddressesCore(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean check(String s, int start, int end){
        if(s.substring(start, end).length() == 1) return true;
        if(s.substring(start, end).startsWith("0"))  return false;
        return s.substring(start, end).length() < 4 && Long.parseLong(s.substring(start, end)) <= 255;
    }

    private String genIP(String s, List<Integer> list){
        StringBuilder sbr = new StringBuilder();
        sbr.append(s.substring(0, list.get(0))).append(".");
        sbr.append(s.substring(list.get(0), list.get(1))).append(".");
        sbr.append(s.substring(list.get(1), list.get(2))).append(".");
        sbr.append(s.substring(list.get(2)));
        return sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(new O02RestoreIpAddresses().restoreIpAddresses("101023"));
    }
}
