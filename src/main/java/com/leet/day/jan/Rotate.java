package com.leet.day.jan;

import java.util.Arrays;

/**
 * @Author: xingxing.chang
 * @Date: 2021/1/11 20:15
 */
public class Rotate {

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0) {
            return;
        }

        for (int i = 0; i < k; i++) {

        }
    }

    public static void main(String[] str) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

}
