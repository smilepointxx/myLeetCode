package com.leet.day.dec;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/18 21:03
 */
public class MaxProfit {

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp[i + 1][0] = Math.max(prices[i] + dp[i][1], dp[i][0]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i] - fee);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices, 2));
    }

}
