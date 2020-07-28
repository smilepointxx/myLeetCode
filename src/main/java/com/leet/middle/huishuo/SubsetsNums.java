package com.leet.middle.huishuo;

import java.util.ArrayList;
import java.util.List;

/**
 * mac os
 * Created by smile on 2020-07-27.
 */
public class SubsetsNums {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubSet = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubSet.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            output.addAll(newSubSet);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(new SubsetsNums().subsetsV2(nums));
    }


    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsV2(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }




}
