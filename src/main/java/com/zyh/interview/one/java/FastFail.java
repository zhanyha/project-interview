package com.zyh.interview.one.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 快速失败
 * @author：zhanyh
 * @date: 2023/7/21
 */
// https://zhuanlan.zhihu.com/p/261705671
public class FastFail {
    public static void main(String[] args) {
        // case 1
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
//            String tmp = iter.next();
//            System.out.println(tmp);
//            if (tmp.equals("1")) {
//                list.remove("1");
//            }
//        }

        // case 2
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
//            String tmp = iter.next();
//            System.out.println(tmp);
//            if (tmp.equals("3")) {
//                list.remove("3");
//            }
//        }

        // case 3
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
//            String tmp = iter.next();
//            System.out.println(tmp);
//            if (tmp.equals("4")) {
//                list.remove("4");
//            }
//        }

        // case 4
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        for (String i : list) {
//            if ("1".equals(i)) {
//                list.remove("1");
//            }
//        }

        // case 5
//        List<String> list = Arrays.asList("1", "2", "3", "4");
//        for (String i : list) {
//            if ("1".equals(i)) {
//                list.remove("1");
//            }
//        }

        // case 6

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String tmp = iter.next();
            System.out.println(tmp);
            if (tmp.equals("1")) {
                iter.remove();
            }
        }
    }
}
