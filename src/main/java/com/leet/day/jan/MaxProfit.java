package com.leet.day.jan;

/**
 * @Author: xingxing.chang
 * @Date: 2021/1/11 19:56
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[][][] dp = new int[prices.length + 1][2][2];
        dp[0][0][2] = 0;
        dp[0][1][2] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {

        }

        return 1;
    }

}
