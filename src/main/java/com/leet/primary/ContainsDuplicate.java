package com.leet.primary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * mac os
 * Created by smile on 2020-07-12.
 */
public class ContainsDuplicate {


    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int index : nums) {
            set.add(index);
        }
        return set.size() != nums.length;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            int index = list.lastIndexOf(nums[i]);
            if (index >= 0 && (i - index) <= k) {
                System.out.println(System.currentTimeMillis() - begin);
                return true;
            }
            list.add(nums[i]);
        }
        System.out.println(System.currentTimeMillis() - begin);
        return false;

    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = new int[]{};
    }
}
