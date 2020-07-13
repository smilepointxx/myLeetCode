package com.leet.recursion;

import java.util.HashMap;

/**
 * mac os
 * Created by smile on 2020-07-12.
 */
public class Fib {

    private HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    private int fib(int N) {
        if (cache.get(N) != null) {
            return cache.get(N);
        }
        int result;
        if (N < 2) {
            result = N;
        } else {
            result = fib(N - 1) + fib(N - 2);
        }
        cache.put(N, result);
        return result;
    }

    public int climbStairs(int n) {
        if (cache.get(n) != null) {
            return cache.get(n);
        }

        int result;
        if (n == 1) {
            result = 1;
        }

        else if (n == 2) {
            result = 2;
        } else {
            result = climbStairs(n - 2) + climbStairs(n - 1);
        }
        cache.put(n, result);
        return result;
    }

}
