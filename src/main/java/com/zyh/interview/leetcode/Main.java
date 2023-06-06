package com.zyh.interview.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/16
 */
public class Main {

    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }

    public static void main(String[] args) {
//        AbstractQueuedSynchronizer
//        ReentrantLock
    }

    private static class Sync extends AbstractQueuedSynchronizer {

    }
}
