package com.leet.middle.array;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/23 15:57
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Queue<int[]> queue = new PriorityQueue<>(intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] interval : intervals) {
            queue.offer(interval);
        }

        List<int[]> list = new ArrayList<>();
        list.add(queue.poll());
        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            int[] last = list.get(list.size() - 1);
            if (interval[0] <= last[1]) { // merge
                last[0] = Math.min(last[0], interval[0]);
                last[1] = Math.max(last[1], interval[1]);
                list.remove(list.size() - 1);
                list.add(last);
            } else { //put new interval
                list.add(interval);
            }
        }
        int[][] ans = new int[list.size()][2];
        int index = 0;
        for (int[] interval : list) {
            ans[index++] = interval;
        }
        return ans;

    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] intervals = new int[][] {
                {2,3},{4,5},{6,7},{8,9},{1,10}
        };
        int[][] ans = merge.merge(intervals);
        for (int[] i : ans) {
            System.out.print(i[0]);
            System.out.print(",");
            System.out.print(i[1]);
            System.out.println();
        }
    }

}
