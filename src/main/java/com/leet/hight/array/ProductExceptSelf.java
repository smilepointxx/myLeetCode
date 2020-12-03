package com.leet.hight.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/30 15:50
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int left = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = left;
            left *= nums[i];
        }


        int right = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] ints = productExceptSelf.productExceptSelf(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
