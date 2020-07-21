package com.leet.primary;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/20 18:29
 */
public class MaxProfit {


    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(new MaxProfit().maxProfit(nums));
    }

}
