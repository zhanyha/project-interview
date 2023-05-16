package com.zyh.interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @description: 207. 课程表
 * @author：zhanyh
 * @date: 2023/5/15
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 输入：numCourses = 4, prerequisites = [[1,0],[1,2],[3,1],[2,3]]
 * 输出：false
 * 解释：总共有 4 门课程。学习课程 3 之前，你需要先完成课程 1 ,
 * 学习课程 1 之前，你又需要先完成课程 2 ；并且学习课程 2 之前，你还应先完成课程 3 。
 * 这是不可能的。
 */
public class CourseSchedule {
    private boolean[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        TreeMap<Integer, List<Integer>> graph = new TreeMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!graph.containsKey(prerequisites[i][0])) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                graph.put(prerequisites[i][0], list);
            } else {
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !canFinishCore(graph, i))
                return false;
        }
        return true;
    }

    private boolean canFinishCore(TreeMap<Integer, List<Integer>> graph, int course) {
        if (visited[course])
            return false;

        visited[course] = true;
        if (graph.get(course) != null) {
            for (Integer nextCourse : graph.get(course)) {
                if (!canFinishCore(graph, nextCourse))
                    return false;
            }
        }
        visited[course] = false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{1, 0},{0,1}}));
    }
}
