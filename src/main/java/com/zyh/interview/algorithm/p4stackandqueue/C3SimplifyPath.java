package com.zyh.interview.algorithm.p4stackandqueue;

import java.util.Stack;

/**
 * @description: 简化路径
 * @author：zhanyh
 * @date: 2023/4/14
 * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），
 * 请你将其转化为更加简洁的规范路径。在 Unix 风格的文件系统中，一个点（.）表示当前目录
 * 本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对
 * 路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * <p>
 * 输入：path = "/a/./foo/../../h2ome/"
 * 输出："/h2ome"
 * 提示：
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径
 */
public class C3SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            if (path.charAt(i) != '.' && path.charAt(i) != '/') {
                int sub = i;
                while (i < path.length() && path.charAt(i) != '/') {
                    i++;
                }
                String fileName = path.substring(sub, i);
                stk.push(fileName);
            } else {
                if (path.charAt(i) == '.') {
                    int sub = i;
                    while (i < path.length() && path.charAt(i) == '.') {
                        i++;
                    }
                    String fun = path.substring(sub, i);
                    if (fun.equals("..")) {
                        if (!stk.isEmpty())
                            stk.pop();
                    } else if (fun.equals(".")) {
                    } else {
                        stk.push(fun);
                    }
                } else {
                    i++;
                }

            }
        }
        StringBuilder sbr = new StringBuilder();
        Stack<String> resStk = new Stack<>();
        int size = stk.size();
        while (!stk.isEmpty()) {
            resStk.push(stk.pop());
        }
        while (!resStk.isEmpty()) {
            sbr.append("/").append(resStk.pop());
        }
        return size == 0 ? "/" : sbr.toString();
    }
}
