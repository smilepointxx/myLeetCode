package com.leet.hight.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/1 16:25
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        int right = nums.length;
        int left = 0;
        while (true) {
            int middle = (right + left) / 2;
            int count = help(middle, nums);

            if (count == middle) {
                left = middle;
            } else {
                if (middle - left == 1 || right - middle == 1) {
                    return middle;
                }
                right = middle;
            }
        }
    }

    private static int help(int n, int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num <= n) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }


}
