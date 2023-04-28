package com.zyh.interview.algorithm.p6recursion.a1treeshape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:  401. 二进制手表
 * @author：zhanyh
 * @date: 2023/4/28
 * 也可以递归 + 回溯法 做
 */
public class C04BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    String mm = m < 10 ? "0" + m : m + "";
                    res.add(h + ":" + mm);
                }
            }
        }
        return res;
    }
}
