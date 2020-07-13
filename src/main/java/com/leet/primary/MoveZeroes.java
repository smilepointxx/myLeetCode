package com.leet.primary;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/13 19:47
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        for (int index = i; index < nums.length; index ++) {
            nums[index] = 0;
        }
    }

}
