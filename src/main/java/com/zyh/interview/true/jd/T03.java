package com.zyh.interview;

import java.util.*;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/12
 */
public class T03 {
    static boolean[][] visited;
    static int res;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        visited = new boolean[m][n];
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++)
            grid[i] = sc.nextLine().toCharArray();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                solve(grid, 0, 0);
            }
        System.out.println(res);
        sc.close();
    }

    private static void solve(char[][] grid, int x, int y) {
        List<Pair> list = new ArrayList<>();
        dfs(grid, x, y, 4, list);
    }

    private static void dfs(char[][] grid, int x, int y, int cnt, List<Pair> list) {
        if (cnt <= 0) {
            if (check1(list) && check2(list)) {
                res += 1;
            }
            return;
        }
        visited[x][y] = true;
        list.add(new Pair(x, y));

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int nextx = x + i;
                int nexty = y + j;
                if (inArea(grid, nextx, nexty) && !visited[nextx][nexty] && grid[nextx][nexty] == 'X') {
                    dfs(grid, nextx, nexty, cnt - 1, list);
                }
            }
        }
        visited[x][y] = false;
        list.remove(list.size() - 1);
    }
    static HashSet<String> set = new HashSet<>();
    private static boolean check2(List<Pair> list) {
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                 if(o1.x != o2.x)
                     return o1.x - o2.x;
                 else
                     return o1.y - o2.y;
            }
        });
        String s = "";
        for (Pair pair : list) {
            s += pair.x;
            s += pair.y;
        }
        if(set.contains(s))
            return false;
        set.add(s);
        return true;
    }

    private static boolean check1(List<Pair> list) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    int d = distance(list.get(i).x, list.get(i).y, list.get(j).x, list.get(j).y);
                    set.add(d);
                }
            }
        }
        return set.size() <= 2;
    }

    private static int distance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    private static boolean inArea(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
