package com.leet.middle.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/19 18:09
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {

        int index = help(nums, target, 0, nums.length - 1);

        if (index == -1) {
            return new int[]{-1, -1};
        }
        int left = helpLeft(nums, target, 0, index);
        int right = helpRight(nums, target, index, nums.length - 1);
        return new int[]{left, right};
    }

    public int help(int[] nums, int target, int left, int right) {

        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;

        if (target > nums[middle]) {
            return help(nums, target, middle + 1, right);
        } else if (target < nums[middle]) {
            return help(nums, target, left, middle - 1);
        } else {
            return middle;
        }

    }

    public int helpLeft(int[] nums, int target, int left, int index) {
        if (left >= index) {
            if (nums[left] == target) {
                return left;
            } else {
                return left + 1;
            }
        }
        int middle = (left + index) / 2;
        if (nums[middle] != target) {
            return helpLeft(nums, target, middle + 1, index);
        } else {
            return helpLeft(nums, target, left, middle - 1);

        }
    }

    public int helpRight(int[] nums, int target, int index, int right) {
        if (index >= right) {
            if (nums[index] == target) {
                return index;
            } else {
                return index - 1;
            }
        }
        int middle = (index + right) / 2;
        if (nums[middle] != target) {
            return helpRight(nums, target, index, middle - 1);
        } else {
            return helpRight(nums, target, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = new int[]{5,7,7,7,8,8,10};
        int[] ints = searchRange.searchRange(nums, 7);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

}
