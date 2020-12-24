package com.leet.hight.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/1 16:25
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
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
        int[] nums = new int[]{3,3,4,2,1};
        System.out.println(findDuplicateV2(nums));
    }

    public static int findDuplicateV2(int[] nums) {
        int n = nums.length - 1;
        if (n < 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans ^= i ^ nums[i - 1];
        }
        return ans ^ nums[n];
    }


}
