package com.zyh.interview.leetcode.p3linklist;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description: FIFO——双端队列
 * @author：zhanyh
 * @date: 2023/6/6
 */
public class FIFOCache {
    class CacheNode {
        int key;
        int value;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, CacheNode> cacheMap;
    private int capacity;
    private int size;
    private Deque<CacheNode> deque;

    public FIFOCache(int capacity) {
        this.cacheMap = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        deque = new LinkedList<>();
    }

    public int get(int key) {
        CacheNode res = cacheMap.get(key);
        return res == null ? -1 : res.value;
    }

    public void put(int key, int value) {
        CacheNode oldNode = cacheMap.get(key);
        if(oldNode == null){
            CacheNode newNode = new CacheNode(key,value);
            cacheMap.put(key, newNode );
            deque.addFirst(newNode);
            size++;
            if (size > capacity) {
                CacheNode removeNode = deque.removeLast();
                cacheMap.remove(removeNode.key);
            }
        }else{
            oldNode.value = value;
        }

    }

    public static void main(String[] args) {
        FIFOCache fifo = new FIFOCache(2);
        fifo.put(1, 10);
        fifo.put(2, 20);
        System.out.println( fifo.get(1));
        fifo.put(2, 30);
        System.out.println( fifo.get(1));
        System.out.println( fifo.get(2));
        fifo.put(4, 40);
        System.out.println(fifo.get(2));
        System.out.println(fifo.get(3));
    }

}
