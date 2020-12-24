package com.leet.primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/13 20:16
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return nums;
        }
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            int index = list.indexOf(target - i);
            if (index >= 0) {
                return new int[]{index, list.size()};
            } else {
                list.add(i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println();
    }


    public int[] twoSumV2(int[] numbers, int target) {
        if (numbers.length == 0) {
            return new int[]{};
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};

    }
}
