package com.leet.primary;

/**
 * mac os
 * Created by smile on 2020-07-12.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int pre = nums[0];
        ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                nums[ans] = nums[i];
                ans ++;
                pre = nums[i];
            }
        }
        return ans;
    }

}
