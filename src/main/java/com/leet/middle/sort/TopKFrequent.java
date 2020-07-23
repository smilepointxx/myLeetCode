package com.leet.middle.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/22 20:17
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int num : map.keySet()) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while(!queue.isEmpty()) {
            ans[i++] = queue.poll();
        }
        return ans;


    }

}
