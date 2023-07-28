package com.zyh.interview.one.p4statckandqueue;

import java.util.*;

/**
 * @description: 单词接龙
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/word-ladder/
public class O08WordLadderII {

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

    private HashMap<String, List<String>> path = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        wordSet.addAll(wordList);
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(beginWord, 0));

        while (!que.isEmpty()) {
            Node poll = que.poll();
            if (poll.word.equals(endWord)){
                List<String> tmp = new ArrayList<>();
                tmp.add(endWord);
                while (path.get(endWord) != null){
                    for(String p : path.get(endWord)){
                        endWord = p;
                        tmp.add(endWord);
                    }
                }
                return res;
            }


            List<Node> nexts = getNext(poll);
            if (!nexts.isEmpty())
                que.addAll(nexts);
        }
        return res;
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
                        if(path.containsKey(newWord)){
                            path.get(newWord).add(node.word);
                        }else{
                            path.put(newWord, new ArrayList<>());
                        }
                        nexts.add(new Node(newWord, node.step + 1));
                        visited.add(newWord);
                    }
                    word[i] = t;
                }
            }
        }
        return nexts;
    }

}
