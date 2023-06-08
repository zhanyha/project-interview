package com.zyh.interview.leetcode.p3linklist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 手写LRU实现
 * @author：zhanyh
 * @date: 2023/6/6
 */
public class LRUCacheBest {
    private HashMap<Integer, CacheNode> cacheMap;
    private int size;
    private int capacity;
    private CacheNode head = new CacheNode();
    private CacheNode tail = new CacheNode();
    class CacheNode{
        int key;
        int value;
        CacheNode pre;
        CacheNode next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public CacheNode() {
        }
    }

    public LRUCacheBest(int capacity) {
        this.cacheMap = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        head.next = tail;
        head.pre = tail;
        tail.next = head;
        tail.pre = head;
    }

    public int get(int key) {
        CacheNode cacheNode = cacheMap.get(key);
        if(cacheNode != null){
            moveToHead(cacheNode);
            return cacheNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        CacheNode cacheNode = cacheMap.get(key);
        if(cacheNode == null){
            CacheNode newNode = new CacheNode(key,value);
            addToHead(newNode);
            cacheMap.put(key, newNode);
            size++;
            if(size > capacity){
                CacheNode removeNode = removeTail();
                cacheMap.remove(removeNode.key);
                size--;
            }
        }else{
            cacheNode.value = value;
            moveToHead(cacheNode);
        }
    }

    private CacheNode removeTail() {
        CacheNode p = tail.pre;
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
        return p;
    }

    private void moveToHead(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addToHead(node);
    }

    private void addToHead(CacheNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }


    public static void main(String[] args) {
        LRUCacheBest lruCache = new LRUCacheBest(2);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 30);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        lruCache.get(2);
        lruCache.get(3);
        lruCache.put(4, 40);
        System.out.println(lruCache.get(3));
    }
}