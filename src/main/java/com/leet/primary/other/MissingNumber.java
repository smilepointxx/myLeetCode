package com.leet.primary.other;

/**
 * mac os
 * Created by smile on 2020-07-18.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i ^ nums[i];
        }
        return ans;
    }

}
