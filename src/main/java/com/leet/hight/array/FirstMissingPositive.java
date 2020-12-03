package com.leet.hight.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/30 19:40
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int middle = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[middle - 1] = middle;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(firstMissingPositive(nums));
    }

}
