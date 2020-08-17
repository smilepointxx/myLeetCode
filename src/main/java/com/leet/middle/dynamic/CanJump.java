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
        for (int i = 1; i <= nums[n]; i++) {
            if (helper(nums, i + n)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(new CanJump().canJumpV2(nums));
    }

    public boolean canJumpV2(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        return helperV2(nums, 0, 0);


    }

    private boolean helperV2(int[] nums, int max, int n) {
        if (max >= nums.length || n >= (nums.length - 1)) {
            return true;
        }

        for (int i = 1; i <= nums[n]; i++) {
            if (helperV2(nums, Math.max(max, n + nums[n]), n + i)) {
                return true;
            }
        }
        return false;

    }

    public boolean canJumpV3(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;


    }


}
