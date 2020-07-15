package com.leet.primary;

/**
 * mac os
 * Created by smile on 2020-07-13.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            helper(i, matrix);
        }
    }

    private void helper(int n, int[][] matrix) {

        int length = matrix.length;
        for (int i = n; i < length - n; i++) {
            for (int j = n; j < length - n; j++) {

            }
        }

    }
}
