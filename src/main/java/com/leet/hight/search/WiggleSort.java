package com.leet.hight.search;

import java.util.Arrays;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/9 17:32
 * <p>
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class WiggleSort {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = (nums.length + 1) / 2;
        int p = 0;
        int[] ans = new int[nums.length];
        while (p < nums.length) {
            ans[p++] = nums[left];
            left++;
            if (p >= nums.length) {
                return;
            }
            ans[p++] = nums[right];
            right++;
        }
        for (int i : ans) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println();
    }

    public static void wiggleSortV2(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = (nums.length + 1) / 2;
        int p = 0;
        int[] ans = new int[nums.length];
        while (p < nums.length) {
            ans[p++] = nums[left];
            left++;
            if (p >= nums.length) {
                return;
            }
            ans[p++] = nums[right];
            right++;
        }
        for (int i : ans) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
    }

}
