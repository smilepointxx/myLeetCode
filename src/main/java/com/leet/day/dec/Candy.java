package com.leet.day.dec;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/31 17:37
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int[] dpLeft = new int[ratings.length];
        dpLeft[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dpLeft[i] = dpLeft[i - 1] + 1;
            } else {
                dpLeft[i] = 1;
            }
        }
        int ans = 0;
        int[] dpRight = new int[ratings.length];
        dpRight[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dpRight[i] = dpRight[i + 1] + 1;
            } else {
                dpRight[i] = 1;
            }

            ans += Math.max(dpRight[i + 1], dpLeft[i + 1]);
        }
        ans += Math.max(dpLeft[0], dpRight[0]);
        return ans;
    }

}
