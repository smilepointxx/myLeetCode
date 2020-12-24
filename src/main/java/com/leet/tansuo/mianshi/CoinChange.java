package com.leet.tansuo.mianshi;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/22 14:27
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
//        for(int i = 0; i <= coins.length; i++) {
//            dp[i][0] = 0;
//        }


        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i- 1][j];
                } else {
                    if (dp[i - 1][j] == 0 && j - coins[i - 1] == 0) {
                        dp[i][j] = 1 + dp[i][j - coins[i - 1]];
                    } else if (dp[i][j - coins[i - 1]] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j -coins[i - 1]]);
                    }
                }
            }
        }

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                System.out.print(dp[i][j]);
                System.out.print(",");
            }
            System.out.println();

        }

        return dp[coins.length][amount];
    }

    public static void main(String[] str) {
        int[] coins = new int[]{2};
        System.out.println(coinChange(coins, 7));
    }

}
