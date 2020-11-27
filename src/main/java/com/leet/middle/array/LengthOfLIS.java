package com.leet.middle.array;

import java.util.Arrays;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/24 20:36
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int a : dp) {
            ans =Math.max(a, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        lengthOfLIS.lengthOfLIS(nums);
    }
}
