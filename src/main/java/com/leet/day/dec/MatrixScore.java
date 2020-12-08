package com.leet.day.dec;

import java.util.Arrays;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/7 20:39
 */
public class MatrixScore {

    public int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                swapNumI(A, i);
            }
        }

        int middle = A.length / 2;
        for (int i = 1; i < A[0].length; i++) {
            int c = countZero(A, i);
            if (c > middle) {
                swapNumJ(A, i);
            }
        }

        int i = 0;
        int ans = 0;
        double n = Math.pow(2, A[0].length - 1);
        while (i < A[0].length) {
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1) {
                    ans += n;
                }
            }
            n = n / 2;
            i++;
        }

        return ans;
    }

    public void swapNumI(int[][] A, int i) {
        for (int j = 0; j < A[0].length; j++) {
            if (A[i][j] == 0) {
                A[i][j] = 1;
            } else {
                A[i][j] = 0;
            }
        }
    }

    public void swapNumJ(int[][] A, int i) {
        for (int j = 0; j < A.length; j++) {
            if (A[j][i] == 0) {
                A[j][i] = 1;
            } else {
                A[j][i] = 0;
            }
        }
    }

    public int countZero(int[][] A, int i) {
        int ans = 0;
        for (int[] ints : A) {
            if (ints[i] == 0) {
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}
        };
        MatrixScore matrixScore = new MatrixScore();
        System.out.println(matrixScore.matrixScore(nums));
    }


}
