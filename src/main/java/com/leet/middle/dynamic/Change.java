package com.leet.middle.dynamic;

/**
 * @Author: xingxing.chang
 * @Date: 2020/8/14 20:41
 */
public class Change {


    public static int change(int[] coins, int amount) {
        if (coins.length == 0) {
            return 0;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {

            for (int index = 0; index <= amount; index++) {
                System.out.print(dp[i - 1][index]);
                System.out.print(",");
            }
            System.out.println();

            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        for (int index = 0; index <= amount; index++) {
            System.out.print(dp[3][index]);
            System.out.print(",");
        }
        System.out.println();
        return dp[coins.length][amount];

    }

    public static void main(String[] str) {
        int[] coins = new int[]{1,2,5};
        System.out.println(change(coins, 5));
    }



}
