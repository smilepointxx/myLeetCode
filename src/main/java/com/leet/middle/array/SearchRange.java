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
        } else if (target < nums[middle]){
            return help(nums, target, left, middle - 1);
        } else {
            return middle;
        }

    }

    public int helpLeft(int[] nums, int target, int left, int right) {
        if (left == right) {
            return left;
        }
        int middle = (left + right) / 2;
        if (nums[middle] != target) {
            return helpLeft(nums, target, middle + 1, right);
        } else {
            return helpLeft(nums, target, left, middle);
        }
    }
    private int helpRight(int[] nums, int target, int left, int right) {
        if (left == right) {
            return left;
        }
        int middle = (left + right) / 2;
        if (nums[middle] != target) {
            return helpRight(nums, target, left, middle - 1);
        } else {
            if (nums[middle + 1] == target) {
                return helpRight(nums, target, middle + 1, right);
            } else {
                return middle;
            }
        }
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = new int[]{1,3,3,3,4};
        int[] ints = searchRange.searchRange(nums, 3);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

}
