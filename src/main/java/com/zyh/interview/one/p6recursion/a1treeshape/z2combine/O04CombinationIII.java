package com.zyh.interview.one.p6recursion.a1treeshape.z2combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/7
 */
public class O04CombinationIII {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum3Core(k , 1, n, list);
        return res;
    }

    private void combinationSum3Core(int k, int start, int n, List<Integer> list) {
        if(n == 0 && list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < 10; i++){
            list.add(i);
            combinationSum3Core(k, i + 1, n - i, list);
            list.remove(list.size() - 1);
        }
    }
}
