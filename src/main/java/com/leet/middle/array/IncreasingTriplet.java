package com.leet.middle.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/6 17:17
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int left = nums[0];
        int middle = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (left < middle && right > middle) {
                return true;
            }
            int num = nums[i];
            if (left >= num) {
                left = num;
                middle = Integer.MIN_VALUE;
                right = Integer.MIN_VALUE;
            } else if (right <= num){
                middle = right;
                right = num;
            } else {
                middle = num;
                right = Integer.MIN_VALUE;
            }
        }
        System.out.println(left);
        System.out.println(middle);
        System.out.println(right);
        return left < middle && right > middle ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,5,5,2,5,4};
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        boolean b = increasingTriplet.increasingTriplet(nums);
        System.out.println(b);
    }

}
