package com.leet.day.nov;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
        for (int n : stones) {
            queue.offer(n);
        }
        while (queue.size() > 1) {
            queue.offer(queue.poll() - queue.poll());
        }
        return queue.poll();
    }

}
