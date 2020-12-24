package com.leet.tansuo.binarysearch;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/23 19:56
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0; int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if(nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return nums[left] > target ? left + 1 : left;
    }

}
