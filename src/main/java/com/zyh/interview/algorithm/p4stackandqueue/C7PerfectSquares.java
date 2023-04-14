package com.zyh.interview.algorithm.p4stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: 完全平方数
 * @author：zhanyh
 * @date: 2023/4/14
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 */
public class C7PerfectSquares {
    class Pair {
        int val;
        int step;

        public Pair(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(n, 0));
        boolean[] visited = new boolean[n + 1];
        while (!que.isEmpty()) {
            Pair poll = que.poll();
            int num = poll.val;
            visited[num] = true;
            if (num == 0)
                return poll.step;
            for (int i = 1; num - i * i >= 0; i++) {
                if (!visited[num - i * i]) {
                    que.add(new Pair(num - i * i, poll.step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new C7PerfectSquares().numSquares(5);
        System.out.println(i);

    }
}
