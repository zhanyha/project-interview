/**
 * @author zhanyuhao
 * @time 2023/2/3 9:08
 */
package com.zyh.interview.java.collections;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapInterview {
    public static void main(String[] args) {
        // treeMap的默认排序机制 ： 按key升序排序
        treeMapSortMachine();

        //
    }

    private static void treeMapSortMachine() {
        Map<String, Integer> map = new TreeMap<>();

        map.put("b", 1);
        map.put("a", 2);
        map.put("d", 1);
        map.put("c", 1);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey() + " : ");
            System.out.println(entry.getValue());
        }
    }
}
