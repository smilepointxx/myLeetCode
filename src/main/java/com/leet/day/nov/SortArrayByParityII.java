package com.leet.day.nov;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/12 11:29
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        if (A.length == 0) {
            return A;
        }
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j = j + 2;
                }
                swap(A, i ,j);
            }
        }
        return A;
    }


    public void swap(int[] A, int i, int j) {
        int mid = A[j];
        A[j] = A[i];
        A[i] = mid;
    }

    public void helper(int i, int[] A, int i1) {
        int j = i - 1;
        for (; i < A.length; i++) {

            if ((A[i] % 2 == 0 && i % 2 == 0) || (A[i] % 2 == 1 && i % 2 == 1)) {
                continue;
            }

            if (A[i] % 2 == i1) {
                int mid = A[j];
                A[j] = A[i];
                A[i] = mid;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 2};
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] ints = sortArrayByParityII.sortArrayByParityII(nums);
        for (int i : ints) {
            System.out.println(i);
        }
    }


}
