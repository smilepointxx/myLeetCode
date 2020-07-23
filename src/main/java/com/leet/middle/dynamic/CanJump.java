package com.leet.middle.dynamic;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/23 20:42
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        boolean helper = helper(nums, 0);
        System.out.println(count);
        return helper;

    }

    int count = 0;

    private boolean helper(int[] nums, int n) {
        count++;
        if (n == nums.length - 1) {
            return true;
        }
        boolean ans = false;
        for (int i = 1; i <= nums[n]; i++) {
            ans = ans || helper(nums, i + n);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2409,2409};
        System.out.println(new CanJump().canJump(nums));
    }

}
