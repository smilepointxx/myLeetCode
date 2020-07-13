package com.leet.tree.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/13 20:16
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return nums;
        }
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            int index = list.indexOf(target - i);
            if (index >= 0) {
                return new int[]{index, list.size()};
            } else {
                list.add(i);
            }
        }
        return new int[]{};
    }

}
