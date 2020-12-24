package com.leet.tansuo.doublepointer;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/16 11:43
 */
public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int cuu = 0;
        int leftSum = 0;

        while (cuu < nums.length) {
            if (leftSum == (sum - nums[cuu] - leftSum)) {
                return cuu;
            }
            leftSum += nums[cuu];
            cuu++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,-1,0,1,1};
        int[] nums1 = new int[]{1,1,0,-1,-1,-1};
        System.out.println(pivotIndex(nums1));
    }

}
