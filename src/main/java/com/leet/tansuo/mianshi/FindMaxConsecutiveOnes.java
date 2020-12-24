package com.leet.tansuo.mianshi;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/24 12:57
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        int ans = 0;
        while (p2 < nums.length) {
            if (nums[p2] == 1) {
                p2++;
            } else {
                ans = Math.max(ans, p2 - p1);
                p2++;
                p1 = p2;
            }
        }
        return Math.max(ans, p2 - p1);
    }
//[1,0,1,1,0,1]
}
