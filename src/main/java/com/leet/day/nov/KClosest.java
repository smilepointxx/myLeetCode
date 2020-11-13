package com.leet.day.nov;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/10 11:19
 */
public class KClosest {

    public int[][] kClosest(int[][] points, int K) {
        List<DisNode> distance = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            distance.add(new DisNode(cal(points[i]), i));
        }
        Queue<DisNode> queue = new PriorityQueue<>(K, new Comparator<DisNode>() {
            @Override
            public int compare(DisNode o1, DisNode o2) {
                if (o1.dis > o2.dis) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (DisNode dis : distance) {
            if (queue.size() == K) {
                DisNode peek = queue.peek();
                if (peek.dis > dis.dis) {
                    queue.poll();
                    queue.offer(dis);
                }
            } else {
                queue.offer(dis);
            }
        }
        System.out.println(queue.size());
        int[][] ans = new int[queue.size()][];
        int index = 0;
        while (!queue.isEmpty()) {
            DisNode poll = queue.poll();
            ans[index] = points[poll.id];
            index++;
        }
        return ans;
    }

    private Integer cal(int[] point) {
        int a = point[0];
        int b = point[1];
        return a * a + b * b;

    }
    class DisNode {
        int dis;
        int id;

        public DisNode(int dis, int id) {
            this.dis = dis;
            this.id = id;
        }
    }

}
