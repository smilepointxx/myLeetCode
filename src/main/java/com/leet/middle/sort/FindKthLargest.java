package com.leet.middle.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * mac os
 * Created by smile on 2020-07-22.
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int num : nums) {
            if (queue.contains(num)) {
                continue;
            }
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

}
