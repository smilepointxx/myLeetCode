package com.leet.day.oct;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/26 15:05
 */
public class LongestMountain {

    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int max = 0;
        for (int n = 0; n < A.length; n++) {
            max = Math.max(help(n, A), max);
        }

        return max;
    }

    private int help(int n, int[] A) {
        int rightMax = 0;
        int cuu = A[n];
        for (int i = n + 1; i < A.length; i++) {
            if (A[i] < cuu) {
                rightMax++;
                cuu = A[i];
            } else {
                break;
            }
        }
        if (rightMax == 0) {
            return 0;
        }
        int leftMax = 0;
        cuu = A[n];
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] < cuu) {
                leftMax++;
                cuu = A[i];
            } else {
                break;
            }
        }
        if (leftMax == 0) {
            return 0;
        }
        return leftMax + rightMax + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,4,7,3,2,5};
        LongestMountain longestMountain = new LongestMountain();
        int i = longestMountain.longestMountain(nums);
        System.out.println(i);
    }

}
