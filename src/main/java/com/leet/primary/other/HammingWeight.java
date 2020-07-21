package com.leet.primary.other;

/**
 * mac os
 * Created by smile on 2020-07-18.
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            System.out.println(n);
            n = n & (n - 1);
            ans ++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new HammingWeight().hammingWeight(-3));
//        System.out.println(-2 & -3);
        System.out.println(-2147483648 - 1);
    }

}
