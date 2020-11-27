package com.leet.day.nov;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/19 11:19
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length < 1) {
            return;
        }

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(left, right, nums);
                left ++;
            }
            right++;
        }
    }

    private void swap(int left, int right, int[] nums) {
        if (left == right) {
            return;
        }

        int index = nums[left];
        nums[left] = nums[right];
        nums[right] = index;
    }

}
