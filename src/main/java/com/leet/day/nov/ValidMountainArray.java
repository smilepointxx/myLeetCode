package com.leet.day.nov;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/3 10:15
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int flag = 0;

        for (int i = 1; i < A.length; i++) {
            if (flag == 0) {
                if (A[i] < A[i - 1]) {
                    if (i == 1) {
                        return false;
                    }
                    flag = 1;
                } else if (A[i] == A[i - 1]) {
                    return false;
                }
            } else {
                if (A[i] >= A[i - 1]) {
                    return false;
                }
            }

        }
        return flag != 0;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        ValidMountainArray validMountainArray = new ValidMountainArray();
        boolean b = validMountainArray.validMountainArray(nums);
        System.out.println(b);
    }

}
