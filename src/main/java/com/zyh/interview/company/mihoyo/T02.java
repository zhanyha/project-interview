package com.zyh.interview.company.mihoyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class T02 {
    private int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < g.length; i++)
            g[i] = new ArrayList<>();
        for (int[] nums : edges)
            g[nums[0] - 1].add(nums[1] - 1);

        T02 t02 = new T02();
        t02.dfs(g, k, 0, 0);
        System.out.println(t02.res);
        sc.close();
    }

    private void dfs(List<Integer>[] g, int k, int root, int depth) {
        if(depth > k) return;
        res++;
        if (depth < k && g[root].size() == 0) {
            res += k - depth;
            return;
        }
        for (Integer e : g[root]) {
            if(depth == 0 && g[root].size() == 1)
                res += k - depth - 1;
            dfs(g, k, e, depth + 1);
        }
    }
}
//3 2
//1 2
//2 3