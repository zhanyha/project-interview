package com.zyh.interview.one.p4statckandqueue;

import java.util.*;

/**
 * @description: 单词接龙
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/word-ladder/
public class O08WordLadder {

    class Node {
        String word;
        int step;

        public Node(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    private HashSet<String> visited = new HashSet<>();

    private HashSet<String> wordSet = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet.addAll(wordList);
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(beginWord, 0));

        while (!que.isEmpty()) {
            Node poll = que.poll();
            if (poll.word.equals(endWord))
                return poll.step;

            List<Node> nexts = getNext(poll);
            if (!nexts.isEmpty())
                que.addAll(nexts);
        }
        return -1;
    }


    // hit hot hog
    //     hat hag
    private List<Node> getNext(Node node) {
        char[] word = node.word.toCharArray();
        visited.add(node.word);
        List<Node> nexts = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != word[i]) {
                    char t = word[i];
                    word[i] = ch;
                    String newWord = new String(word);
                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        nexts.add(new Node(newWord, node.step + 1));
                        visited.add(newWord);
                    }
                    word[i] = t;
                }
            }
        }
        return nexts;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        new O08WordLadder().ladderLength("hit",
                "cog",
                        wordList);
    }
}
