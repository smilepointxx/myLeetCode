package com.leet.primary;

/**
 * mac os
 * Created by smile on 2020-07-12.
 */
public class SingleNumber {


    public int singleNumber(int[] nums) {

        int ans = nums[1];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        SingleNumber number = new SingleNumber();
        System.out.println(number.singleNumber(nums));
    }
}
