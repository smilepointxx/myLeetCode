package com.leet.primary.other;

/**
 * mac os
 * Created by smile on 2020-07-18.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int s = x ^ y;
        int ans = 0;
        while (s != 0) {
            s = s & (s - 1);
            ans ++;
        }
        return ans;

    }

}
