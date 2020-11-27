package com.leet.day.nov;


import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/16 12:40
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        int[] ans = new int[arr1.length];
        int i = 0;
        for (int num : arr2) {
            for (int j = 0; j < map.get(num); j++) {
                ans[i] = num;
                i++;
            }
            map.remove(num);

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                queue.offer(entry.getKey());
            }
        }
        System.out.println(i);
        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ans[i] = poll;
            i++;
        }
        return ans;
    }

}
