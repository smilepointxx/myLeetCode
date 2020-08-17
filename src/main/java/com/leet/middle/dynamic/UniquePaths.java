package com.leet.middle.dynamic;

/**
 * mac os
 * Created by smile on 2020-07-29.
 */
public class UniquePaths {

    public int ans = 0;

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        helper(m, n);
        return ans;
    }

    private void helper(int m, int n) {

        if (m == 1 || n == 1) {
            ans++;
            return;
        }
        helper(m - 1, n);
        helper(m ,n - 1);
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
