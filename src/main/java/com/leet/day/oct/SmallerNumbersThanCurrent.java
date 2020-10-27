package com.leet.day.oct;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/26 11:51
 */
public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length == 0) {
            return new  int[]{};
        }
        int[] result = new int[101];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i] + 1; j <= 100; j ++) {
                result[j] = result[j] + 1;
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            ans[i] = result[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        SmallerNumbersThanCurrent smallerNumbersThanCurrent = new SmallerNumbersThanCurrent();
        int[] ints = smallerNumbersThanCurrent.smallerNumbersThanCurrent(nums);
        for (int i : ints) {
            System.out.println(i);
        }
    }

}
