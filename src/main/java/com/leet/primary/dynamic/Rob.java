package com.leet.primary.dynamic;

/**
 * mac os
 * Created by smile on 2020-07-18.
 */
public class Rob {

    public int rob(int[] nums) {
        int ans = 0;
        if (nums.length == 0) {
            return ans;
        }
        int[] max = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < 2) {
                max[i] = nums[i];
                ans = Math.max(ans, nums[i]);
                continue;
            } else if (i == 2) {
                max[i] = nums[0] + nums[2];
                ans = Math.max(ans, max[i]);
                continue;
            }

            max[i] = Math.max(nums[i] + max[i - 2], nums[i] + max[i - 3]);
            ans = Math.max(ans, max[i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        System.out.println(new Rob().rob(nums));
    }


}
