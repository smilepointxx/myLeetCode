package com.leet.middle.sort;

/**
 * mac os
 * Created by smile on 2020-07-22.
 */
public class SearchRange {


    public int[] searchRange(int[] nums, int target) {

//        helper(nums, target);
        return new int[1];

    }

    /**
     * @param nums
     * @param target
     */
    private void helper(int[] nums, int target, int left, int right) {

        int l = left;
        int r = right;

        //找left区间小于target的第一个数字  right区间第一个大于target的数字
        int mid = (left + right) / 2;
        if (nums[mid] > target) {

        }
        while (left != right) {

        }


    }

}
