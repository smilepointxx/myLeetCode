package com.leet.primary.dynamic;

/**
 * mac os
 * Created by smile on 2020-07-18.
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum = Math.max(sum + n, n);
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }

}
