package com.leet.day.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/10 10:30
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int left = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                left = i;
                break;
            }
        }
        if (left == -1) {
            Arrays.sort(nums);
            return;
        }
        int right = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[left]) {
                right = i;
                break;
            }
        }
        if (right == -1) {
            Arrays.sort(nums);
            return;
        }
        wap(left, right, nums);

        Arrays.sort(nums, left + 1, nums.length);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void wap(int left, int right, int[] nums) {
        int index = nums[left];
        nums[left] = nums[right];
        nums[right] = index;
    }


    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        helper(output, ans, nums.length, 0);
        return ans;
    }

    private void helper(List<Integer> output, List<List<Integer>> ans, int length, int i) {

        if (i == length) {
            ans.add(new ArrayList<>(output));
        }
        for (int index = i; index < length; index++) {
            Collections.swap(output, i, index);
            helper(output, ans, length, i + 1);
            Collections.swap(output, index, i);
        }

    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{4,5,2,6,3,1};
        nextPermutation.nextPermutation(nums);
    }


}
