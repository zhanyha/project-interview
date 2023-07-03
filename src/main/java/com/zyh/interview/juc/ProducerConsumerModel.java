package com.zyh.interview.juc;

import java.util.LinkedList;
import java.util.Random;

/**
 * @description: 生产者消费者模型
 * @author：zhanyh
 * @date: 2023/7/3
 */
public class ProducerConsumerModel {

    public static void main(String[] args) {
        EventPublisher eventPublisher = new EventPublisher(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Producer producer = new Producer(eventPublisher);
                producer.produce();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Consumer consumer = new Consumer(eventPublisher);
                consumer.consume();
            }
        }).start();
    }

}

class Producer {
    private final EventPublisher eventPublisher;

    public Producer(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void produce() {
        for (int i = 0; i < 100; i++) {
            eventPublisher.put(new Random().nextInt(10000));
        }
    }
}

class Consumer {
    private final EventPublisher eventPublisher;

    public Consumer(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void consume() {
        for (int i = 0; i < 100; i++) {
            eventPublisher.take();
        }
    }
}

class EventPublisher {
    private LinkedList<Integer> queue;
    private final int size;

    public EventPublisher(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public void put(Integer data) {
        synchronized (this) {
            if (queue.size() == size) {
                try {
                    System.out.println("队列满，生产者等待");
                    wait();
                    System.out.println("队列未满，生产者继续");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(data);
            System.out.println("生成者生产了 " + data + ", 还有" + queue.size());
            notify();
        }
    }

    public void take() {
        synchronized (this) {
            if (queue.size() == 0) {
                try {
                    System.out.println("队列空，消费者等待");
                    wait();
                    System.out.println("队列非空，消费者继续");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("消费者消费了 " + queue.poll() + ", 还剩下" + queue.size());
            notify();
        }
    }
}