package com.zyh.interview.leetcode.p1arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/16
 */
public class MergeString {
    public String mergeStrings(List<String> strings) {
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(mergeSort(string));
        }
        return res.toString();
    }

    private String mergeSort(String s) {
        char[] chars = s.toCharArray();
        mergeSortCore(chars, 0, s.length() - 1);
        return new String(chars);
    }

    private void mergeSortCore(char[] chs, int l, int r) {
        if (r > l) {
            int mid = (r + l) / 2;
            mergeSortCore(chs, l, mid);  // [l, mid] + [mid+1, r] = [l, r]
            mergeSortCore(chs, mid + 1, r);
            merge(chs, l, mid, r);
        }
    }

    private void merge(char[] chs, int left, int mid, int right) {
        char[] chars = Arrays.copyOf(chs, chs.length);
        int p = left;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (chars[l] < chars[r])
                chs[p++] = chars[l++];
            else
                chs[p++] = chars[r++];
        }
        while (l <= mid) {
            chs[p++] = chars[l++];
        }
        while (r <= right) {
            chs[p++] = chars[r++];
        }
    }

    public static void main(String[] args) {
        String s = "yujwedjhccdskdsewirewrwsadm,fnsdklwweqpq";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'w') {
                list.add(i);
            }
        }
        List<String> strs = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            strs.add(s.substring(list.get(i - 1) + 1, list.get(i) + 2));
        }
        System.out.println(strs);
        String res = new MergeString().mergeStrings(strs);
        System.out.println(res);
    }
}
