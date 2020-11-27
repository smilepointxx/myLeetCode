package com.leet.day.nov;

import java.util.Arrays;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/27 10:56
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(nums[i] - nums[i - 1], ans);
        }
        return ans;
    }

}
