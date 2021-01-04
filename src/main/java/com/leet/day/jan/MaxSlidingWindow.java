package com.leet.day.jan;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: xingxing.chang
 * @Date: 2021/1/4 20:35
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        Deque<Integer> deque = new LinkedBlockingDeque<>();
        int[] ans = new int[nums.length - k + 1];

        deque.offer(0);
        for (int i = 1; i < nums.length; i++) {
            if (i < k - 1) {
                if (nums[deque.peekLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.offerFirst(i);
                continue;
            }
            int lastId = deque.peekLast();
            int firstId = deque.peekFirst();

            if(nums[i] >= nums[firstId]) {
                deque.removeFirst();
            }
            deque.offerFirst(i);
            if (i - lastId >= k) {
                deque.removeLast();
            }
            ans[i - k + 1] = nums[deque.peekLast()];
        }
        return ans;
    }

    public static void main(String[] str) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ans = maxSlidingWindow(nums, 3);
    }
}
