package com.leet.primary;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/13 19:16
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums1.length);
        for (int i : nums1) {
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
        }

        int[] ans = new int[nums1.length];
        int index = 0;
        for (int i : nums2) {
            Integer n = map.get(i);
            if (n != null && n != 0) {
                ans[index] = i;
                index++;
                map.put(i, n - 1);
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }

}
