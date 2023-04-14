package com.zyh.interview.algorithm.p4stackandqueue;

import com.sun.javafx.collections.MapAdapterChange;

import java.util.*;

/**
 * @description:  单词接龙 II
 * @author：zhanyh
 * @date: 2023/4/14
 */
public class C9WordLadderII {
    class Pair {
        String word;
        int step;

        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    private Set<String> visited;
    private HashSet<String> wordSet;

    // Map<下一个节点，当前节点> 方便快速找到下一个节点是从哪个节点来的
    private Map<String, String> paths = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return null;
        List<List<String>> res = new ArrayList<>();
        visited = new HashSet<>();
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(beginWord, 0));
        visited.add(beginWord);
        while (!que.isEmpty()) {
            Pair poll = que.poll();
            if (poll.word.equals(endWord)) {
                List<String> line = new ArrayList<>();
                line.add(endWord);
                String s = paths.get(endWord);
                while (!s.equals(beginWord)){
                    line.add(s);
                    s = paths.get(s);
                }
                line.add(beginWord);
                Collections.reverse(line);
                res.add(line);
            }
            List<Pair> nexts = nextStatus(poll);
            que.addAll(nexts);
        }
        return res;
    }

    private List<Pair> nextStatus(Pair pair) {
        List<Pair> nexts = new ArrayList<>();
        char[] chars = pair.word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (pair.word.charAt(i) != ch) {
                    chars[i] = ch;
                    String newStr = String.valueOf(chars);
                    if (wordSet.contains(newStr) && !visited.contains(newStr)) {
                        nexts.add(new Pair(newStr, pair.step + 1));
                        visited.add(newStr);
                        // 记录下一个可能的节点是从当前节点来的
                        paths.put(newStr, pair.word);
                    }
                    chars[i] = pair.word.charAt(i);
                }
            }
        }
        return nexts;
    }

    public static void main(String[] args) {
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> words = new ArrayList<>(Arrays.asList(wordList));
        String begin = "hit";
        String end = "cog";
        System.out.println(new C9WordLadderII().findLadders(begin, end, words));
    }
}
