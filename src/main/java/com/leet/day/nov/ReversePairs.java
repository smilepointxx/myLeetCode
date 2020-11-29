package com.leet.day.nov;

public class ReversePairs {

    public int reversePairs(int[] nums) {
        int ans = 0;
        if (nums.length < 2) {
            return ans;
        }
        for (int i  = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < Integer.MAX_VALUE / 2 && nums[j] < Integer.MIN_VALUE / 2 && nums[i] > nums[j] * 2) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(nums));
    }

}
