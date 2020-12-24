package com.leet.tansuo.mianshi;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/20 17:04
 */
public class MaxProduct {

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num1 = dp[i - 1][0] * nums[i];
            int num2 = dp[i - 1][1] * nums[i];
            dp[i][0] = Math.min(Math.min(num1, num2), nums[i]);
            dp[i][1] = Math.max(Math.max(num1, num2), nums[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }

    public static void main(String[] str) {
        int[] nums = new int[]{
                -2,3,-4};

        System.out.println(maxProduct(nums));
    }

}
