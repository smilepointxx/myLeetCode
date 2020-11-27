package com.leet.middle.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * mac os
 * Created by smile on 2020-07-29.
 */
public class UniquePaths {


    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return helper(m, n);
    }

    public static Map<Integer, Map<Integer, Integer>> cache = new HashMap();

    public int helper(int m, int n) {

        if (m == 1 || n == 1) {
            return 1;
        } else {
            int val1;
            if (cache.get(m - 1) != null && cache.get(m - 1).get(n) != null) {
                val1 = cache.get(m - 1).get(n);
            } else {
                val1 = helper(m - 1, n);
            }

            int val2;

            if (cache.get(m) != null && cache.get(m).get(n - 1) != null) {
                val2 = cache.get(m).get(n - 1);
            } else {
                val2 = helper(m, n - 1);
            }

            Map<Integer, Integer> map1 = new HashMap<>();
            map1.put(n, val1);
            cache.put(m - 1, map1);

            Map<Integer, Integer> map2 = new HashMap<>();
            map2.put(n - 1, val2);
            cache.put(m, map2);
            return val1 + val2;
        }

    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(51,9));
    }


    public int uniquePathsV2(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        return 1;

    }


}
