package com.zyh.interview.algorithm.p6recursion.a1treeshape.z2combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 组合总和 III
 * @author：zhanyh
 * @date: 2023/4/26
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class C4CombinationIII {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        if (k >= n)
            return res;
        List<Integer> list = new ArrayList<>();
        combineCore(1, n, k, list);
        return res;
    }

    private void combineCore(int start, int n, int k, List<Integer> list) {
        if (k == list.size()) {
            if (n == 0)
                res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            combineCore(i + 1, n - i, k, list);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new C4CombinationIII().combinationSum3(7, 3));
    }
}
