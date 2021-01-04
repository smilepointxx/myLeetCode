package com.leet.day.dec;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/31 17:22
 */
public class EraseOverlapIntervals {

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
        int ans = 0;
        int[] cuu = queue.poll();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (cuu[1] <= poll[0]) { // 无重叠
                cuu = poll;
            } else {
                if (cuu[1] > poll[1]) {  //重叠之后删除右区间最大的那个区间
                    cuu = poll;
                }
                ans ++;
            }
        }
        return ans;

    }

}
