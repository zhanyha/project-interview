package com.zyh.interview.algorithm.p6recursion.a1treeshape.z2combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 组合问题
 * @author：zhanyh
 * @date: 2023/4/26
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class C1Combination {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (k > n)
            return res;
        List<Integer> list = new ArrayList<>();
        combineCore(1, n, k, list);
        return res;
    }

    private void combineCore(int i, int n, int k, List<Integer> list) {
        if (k == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (i <= n) {
            list.add(i);
            combineCore(i + 1, n, k, list);
            list.remove(list.size() - 1);
            combineCore(i + 1, n, k, list);

        }
    }
}
