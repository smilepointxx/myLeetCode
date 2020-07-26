package com.leet.middle.huishuo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * mac os
 * Created by smile on 2020-07-26.
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> outPut = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            outPut.add(nums[i]);
        }
        helper(outPut, ans, nums.length, 0);
        return ans;
    }

    private void helper(List<Integer> nums, List<List<Integer>> ans, int length, int i) {
        if (i == length) {
            ans.add(new ArrayList<Integer>(nums));
        }
        for (int index = i; index < length; index++) {
            Collections.swap(nums, i, index);
            helper(nums, ans, length, i + 1);
            Collections.swap(nums, index, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(new Permute().permute(nums));
    }

}
