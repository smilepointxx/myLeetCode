package com.leet.tansuo.mianshi;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/24 12:48
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0; int p2 = 0;
        while (p2 < nums.length) {
            if (nums[p2] == val) {
                p2++;
            } else {
                nums[p1++] = nums[p2++];
            }
        }
        return p1;
    }

}
