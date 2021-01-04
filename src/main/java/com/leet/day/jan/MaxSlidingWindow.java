package com.leet.day.jan;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: xingxing.chang
 * @Date: 2021/1/4 20:35
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k < 2) {
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


            while (!deque.isEmpty()) {
                if(nums[i] >= nums[deque.peekFirst()]) {
                    deque.removeFirst();
                } else {
                    break;
                }
            }
            deque.offerFirst(i);
            int lastId = deque.peekLast();
            if (i - lastId >= k) {
                deque.removeLast();
            }
            ans[i - k + 1] = nums[deque.peekLast()];
        }
        return ans;
    }

    public static void main(String[] str) {
        int[] nums = new int[]{-7,-8,7,5,7,1,6,0};
        int[] ans = maxSlidingWindow(nums, 4);
        for (int i : ans) {
            System.out.println(i);
        }

    }
}
