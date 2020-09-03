package com.leet.middle.dynamic;

/**
 * @Author: xingxing.chang
 * @Date: 2020/8/14 20:41
 */
public class CoinChange {

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount];
        return helper(coins, amount, count);
    }

    public int helper(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int res = helper(coins, amount - c, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return coins[amount - 1];
    }

}
