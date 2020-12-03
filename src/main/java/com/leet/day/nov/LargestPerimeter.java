package com.leet.day.nov;

import java.util.Arrays;

public class LargestPerimeter {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int length = A.length - 1;
        for (int i = length; i >= 2; i--)
            for (int j = i - 1; j >= 1; j--) {
                if (A[j] + A[j - 1] > A[i]) {
                    return A[j] + A[j - 1] + A[i];
                }
            }
        return 0;
    }

}
