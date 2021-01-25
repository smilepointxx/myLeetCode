package com.leet.day.jan;

public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int max = 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
                i++;
                max++;
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
