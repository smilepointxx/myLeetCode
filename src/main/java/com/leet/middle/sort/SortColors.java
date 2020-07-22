package com.leet.middle.sort;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/22 16:58
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int current = 0;
        while (current <= p2) {
            if (nums[current] == 0) {
                if (current == p0) {
                    current++;
                } else {
                    swap(nums, current, p0);
                }
                p0++;
                continue;
            }

            if (nums[current] == 2) {
                swap(nums, current, p2);
                p2--;
                continue;
            }
            current++;
        }
    }

    private void swap(int[] nums, int current, int i) {
        if (current == i) {
            return;
        }
        int index = nums[i];
        nums[i] = nums[current];
        nums[current] = index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};

        new SortColors().sortColors(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

}
