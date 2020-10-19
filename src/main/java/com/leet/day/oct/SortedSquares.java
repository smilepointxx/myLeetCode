package com.leet.day.oct;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/19 11:16
 */
public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return new int[]{};
        }
        int p1 = 0;
        int p2 = A.length - 1;
        int p11 = A[p1] * A[p1];
        int p22 = A[p2] * A[p2];
        int[] ans = new int[A.length];
        int index = 0;
        while (p2 >= p1) {
            if (p11 < p22) {
                ans[index] = p11;
                p1 ++;
                p11 = A[p1] * A[p1];
            } else {
                ans[index] = p22;
                p2 --;
                p22 = A[p2] * A[p2];
            }
            index ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] nums = new int[]{};
        int[] ans = sortedSquares.sortedSquares(nums);
        for (int a : ans) {
            System.out.println(a);
        }
    }
}
