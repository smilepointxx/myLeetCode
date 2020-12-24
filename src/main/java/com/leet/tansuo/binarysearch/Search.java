package com.leet.tansuo.binarysearch;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/16 18:42
 */
public class Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return help(nums, left, right, target);
    }

    private int help(int[] nums, int left, int right, int target) {
        if (left == right && nums[left] == target) {
            return left;
        }
        int middle = (left + right) / 2;
        if (nums[middle] > target) {
            return help(nums, left, middle - 1, target);
        } else {
            return help(nums, middle + 1, right, target);
        }

    }

}
