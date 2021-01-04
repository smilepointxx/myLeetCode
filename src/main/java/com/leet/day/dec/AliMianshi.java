package com.leet.day.dec;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/31 19:37
 */
public class AliMianshi {


    public Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    static class Node {
        int data;
        Node next;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] interval : intervals) {
            queue.offer(interval);
        }
        int[] cuu = queue.poll();
        int ans = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (cuu[1] <= poll[0]) { //无重叠
                cuu = poll;
            } else {
                if (cuu[1] > poll[1]) {
                    cuu = poll;
                }
                ans ++;
            }

        }
        return ans;

    }


}
