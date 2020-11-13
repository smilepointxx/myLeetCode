package com.leet.day.nov;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/10 17:22
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {

        if (prices.length < 1) {
            return 0;
        }

        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int index = i + 1;
            dp[index][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[index][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[prices.length][0];
    }

}
