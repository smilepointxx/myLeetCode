package com.leet.tansuo.mianshi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/21 17:09
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        Queue<Integer> queue = new PriorityQueue<>(nums.length, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.toString().compareTo(o1.toString());
            }
        });
        for (int num : nums) {
            queue.offer(num);
        }
        StringBuffer buffer = new StringBuffer();
        while (!queue.isEmpty()) {
            buffer.append(queue.poll());
        }
        String ans = buffer.toString();
        return ans.startsWith("0") ? "0" : ans;
    }

    public static void main(String[] str) {
        System.out.println("a".compareTo("b"));
    }

}
