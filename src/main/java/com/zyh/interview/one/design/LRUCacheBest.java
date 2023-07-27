package com.zyh.interview.one.design;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/20
 */
public class LRUCacheBest {
    private HashMap<Integer, CacheNode> cache;
    private int size = 0;
    private int capacity;
    private CacheNode head, tail;

    public LRUCacheBest(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-2, -2);
        head.next = tail;
        tail.pre = head;
    }

    public Integer get(Integer key) {
        CacheNode res = cache.get(key);
        if (res != null) {
            moveToHead(res);
            return res.value;
        }
        return -1;
    }

    public void put(Integer key, Integer value) {
        CacheNode isExistNode = cache.get(key);
        if (isExistNode == null) {
            size++;
            CacheNode cacheNode = new CacheNode(key, value);
            cache.put(key, cacheNode);
            addToHead(cacheNode);
            if (size > capacity) {
                cache.remove(tail.pre.key);
                removeFromTail();
                size--;
            }
        } else {
            isExistNode.value = value;
            moveToHead(isExistNode);
        }
    }

    private void moveToHead(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        addToHead(node);
    }

    private void removeFromTail() {
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
    }

    private void addToHead(CacheNode node) {
        node.next = head.next;
        head.next.pre = node;

        head.next = node;
        node.pre = head;
    }

}

class CacheNode {
    Integer value;
    Integer key;
    CacheNode pre;
    CacheNode next;

    public CacheNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
