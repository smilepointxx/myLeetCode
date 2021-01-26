package com.leet.day.jan;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2021/1/18 19:24
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        if (accounts.size() == 0) {
            return ans;
        }

        Map<String, String> map = new HashMap<>();
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                map.put(list.get(i), name);
            }
        }
        Map<String, PriorityQueue<String>> middle = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            PriorityQueue<String> queue = middle.getOrDefault(entry.getValue(), new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            }));
            queue.add(entry.getKey());
            middle.put(entry.getValue(), queue);
        }

        for (Map.Entry<String, PriorityQueue<String>> entry : middle.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(entry.getKey());
            PriorityQueue<String> queue = entry.getValue();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            ans.add(list);
        }
        return ans;
    }

}
