package com.leet.hight.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/30 18:01
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,1,4};
        System.out.println(maxArea(nums));
    }

}
