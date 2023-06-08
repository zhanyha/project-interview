package com.zyh.interview.leetcode.p3linklist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: LRU实现
 * @author：zhanyh
 * @date: 2023/6/6
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.put(4, 40);
        System.out.println(lruCache.get(1));
    }
}