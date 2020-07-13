package com.leet.recursion;

/**
 * mac os
 * Created by smile on 2020-07-12.
 */
public class KthGrammar {

    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        int ans = kthGrammar(N - 1, (K + 1) / 2);
        if (ans == 0) {
            return 1 - K % 2;
        } else {
            return K % 2;
        }
    }

}
