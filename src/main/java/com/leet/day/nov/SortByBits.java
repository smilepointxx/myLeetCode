package com.leet.day.nov;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/6 15:36
 */
public class SortByBits {


    public int[] sortByBits(int[] arr) {

        Queue<Integer> queue = new PriorityQueue<>(arr.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = helper(o1);
                int b = helper(o2);
                if (a > b) {
                    return -1;
                } else if (a < b){
                    return 1;
                } else {
                    if (o1 > o2) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        for (int i : arr) {
            queue.offer(i);
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }


    public int helper(int m) {
        int ans = 0;
        while (m != 0) {
            m = m & (m - 1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 3;
        SortByBits sortByBits = new SortByBits();
        int helper = sortByBits.helper(-1);
        System.out.println(helper);
    }

}
