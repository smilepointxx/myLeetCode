package com.leet.middle.sort;

/**
 * mac os
 * Created by smile on 2020-07-22.
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = nums[0];
        int middle = Integer.MIN_VALUE;

        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
             if (nums[i] <= left) {
                 left = nums[i];
             } else if (middle <= nums[i]) {
                 middle = nums[i];
                 ans = i;
             } else {
                 return ans;
             }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
