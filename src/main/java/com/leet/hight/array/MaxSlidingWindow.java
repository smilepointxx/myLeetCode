package com.leet.hight.array;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/3 19:57
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedBlockingDeque<>(k);
        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                ans[index++] = nums[deque.peek()];
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = new int[]{4,4,6,6,6,5};
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }

}
