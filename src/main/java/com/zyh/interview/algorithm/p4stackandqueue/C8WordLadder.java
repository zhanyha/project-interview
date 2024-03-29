package com.zyh.interview.algorithm.p4stackandqueue;

import java.util.*;

/**
 * @description: 单词接龙
 * @author：zhanyh
 * @date: 2023/4/14
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列
 * 每一对相邻的单词只差一个字母。对于 1 <= i <= k 时，每个 si 都在 wordList 中。
 * 注意， beginWord 不需要在 wordList 中。
 * 输入：beginWord = "hit", endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * endWord可能不会出现再wordList中
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 */
public class C8WordLadder {
    class Pair {
        String word;
        int step;

        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    private Map<String, Boolean> visited;
    private HashSet<String> wordSet;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        visited = new HashMap<>();
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(beginWord, 0));
        visited.put(beginWord, true);
        while (!que.isEmpty()) {
            Pair poll = que.poll();
            if (poll.word.equals(endWord))
                return poll.step + 1;
            List<Pair> nexts = nextStatus(poll);
            que.addAll(nexts);
        }
        return 0;
    }

    private List<Pair> nextStatus(Pair pair) {
        List<Pair> nexts = new ArrayList<>();
        char[] chars = pair.word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (pair.word.charAt(i) != ch) {
                    chars[i] = ch;
                    String newStr = String.valueOf(chars);
                    if (wordSet.contains(newStr) && visited.get(newStr) == null) {
                        nexts.add(new Pair(newStr, pair.step + 1));
                        visited.put(newStr, true);
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
        System.out.println(new C8WordLadder().ladderLength(begin, end, words));
    }
}
