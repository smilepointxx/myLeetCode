package com.leet.primary.dynamic;

/**
 * mac os
 * Created by smile on 2020-07-18.
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i : prices) {
            if (i < min) {
                min = i;
            } else {
                ans = Math.max(ans, i - min);
            }
        }

        return ans;
    }


    public int maxProfitV2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i ++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], - prices[i]);
        }
        return dp[prices.length][0];

    }


    public int maxProfitV2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{7,1,5,3,6,4};
        new MaxProfit().maxProfitV2(nums);
//        System.out.println();
    }



}
